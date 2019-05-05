import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { of } from 'rxjs';

const tokenHeader = new HttpHeaders({
  'Authorization': 'Basic Y2xpZW50OnNlY3JldA==', // this is the encoding of (clientId:secret)
  'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
});

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  refreshTokenExpiration: number = 60;
  constructor(private http: HttpClient, private router: Router) { }

  login(credentials: Object) {
    console.log('login Service')
    const body = 'username=' + credentials['email'] + '&password=' + credentials['password'] + '&grant_type=password';
    return this.http.post('/api/oauth/token', body, { headers: tokenHeader });
  }
  refreshToken() {
    const refreshToken = this.getCookie('refresh-token');
    const body = 'refresh_token=' + refreshToken + '&grant_type=refresh_token';
    return this.http.post('/api/oauth/token', body, { headers: tokenHeader });
  }
  isAuthenticated(): boolean {
    return (this.getCookie('access-token') != null);
  }

  logout() {
    if (this.getCookie('user')) {
      let email = JSON.parse(this.getCookie('user'))['email'];
      localStorage.clear();
      this.deleteCookie(['access-token', 'refresh-token', 'user']);
      return this.http.post('/api/logout', email)
        .subscribe(result => {
        }, err => { });
    } else {
      localStorage.clear();
      this.deleteCookie(['access-token', 'refresh-token', 'user']);
      return of();
    }

  }

  deleteCookie(names: string[]) {
    names.forEach(name => {
      document.cookie = name + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    })
  }

  storeAccessToken(accessToken: string, expiresIn: string) {
    let accessTokenExpiration = new Date(new Date().getTime() + parseInt(expiresIn) * 1000).toUTCString();
    document.cookie = 'access-token=' + accessToken + ';expires=' + accessTokenExpiration;
  }

  storeRefreshToken(refreshToken: string) {
    let refreshTokenExpiration = new Date(new Date().getTime() + this.refreshTokenExpiration * 1000).toUTCString();
    document.cookie = 'refresh-token=' + refreshToken + ";expires=" + refreshTokenExpiration;
  }

  redirectUser = (role: string) => {
    this.router.navigate(['/' + role.toLowerCase()]);
  }

  /*
  * stores user info
  * @param client: any
  */
  storeUser(user: any): void {
    let userToStore = JSON.stringify(user);
    let expiration = new Date(new Date().getTime() + this.refreshTokenExpiration * 1000).toUTCString();
    localStorage.setItem('role', user['role']['name']);
    document.cookie = 'user=' + userToStore + ';expires=' + expiration;
  }

  getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }

}
