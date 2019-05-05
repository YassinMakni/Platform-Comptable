import { LoginService } from '../../services/login.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  wrongCredentials = false;
  isDataLoaded = true;
  isAuthenticated = () => this.loginService.isAuthenticated();

  constructor(private loginService: LoginService, private router: Router) {
    this.loginForm = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    });
  }

  ngOnInit() {
    this.loginService.logout();
  }

  onSubmit({ value, Valid }) {
    const userCredentials = { email: value.email, password: value.password };
    console.log('Logging In...')
    this.loginService.login(userCredentials).subscribe(result => { // store the user credentials TODO store full name & profile img
      
      this.loginService.storeAccessToken(result['access_token'], result['expires_in']);
      this.loginService.storeRefreshToken(result['refresh_token']);
      this.loginService.storeUser(result['user'])
      this.isAuthenticated();
      this.loginService.redirectUser(localStorage.getItem('role'));
    }, err => {
        this.router.navigate(['/login']);
    });
  }

}
