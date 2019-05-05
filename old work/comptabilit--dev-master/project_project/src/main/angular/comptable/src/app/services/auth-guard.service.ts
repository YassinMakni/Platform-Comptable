import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private loginService: LoginService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot) {
    const expectedRole = route.data.roles;
    const role = () => {
      return localStorage.getItem('role');
    };


    if (this.loginService.isAuthenticated()) { // after refreshing the token or the user is already authenticated
      if (expectedRole.indexOf(role()) > -1) { // the user has an appropriate role
        return true;
      }
      return false;
    }
  }
}
