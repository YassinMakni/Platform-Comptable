import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap, filter, take, switchMap, catchError, finalize } from 'rxjs/operators';
import { LoginService } from './login.service';
@Injectable()
export class AuthInterceptorService implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    throw new Error("Method not implemented.");
  }

  isRefreshingToken: boolean = false;
  tokenSubject: BehaviorSubject<string> = new BehaviorSubject<string>(null);
  constructor(private loginService: LoginService, private router: Router) { }

  addToken(req: HttpRequest<any>, token: string): HttpRequest<any> {
    return req.clone({ setHeaders: { Authorization: 'Bearer ' + token } })
  }


  // intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  //   let accessToken = this.loginService.getCookie('access-token');
  //   let refreshToken = this.loginService.getCookie('refresh-token');
  //   if (req.url != "/api/oauth/token") {
  //     return next.handle(accessToken ? this.addToken(req, accessToken) : this.addToken(req, '123'))
  //       .pipe(
  //         tap(event => {
  //           if (event instanceof HttpResponse) {
  //             console.log(' all looks good');
  //           }
  //         }, error => {
  //           // http response status code
  //           console.log('----response----');
  //           console.error('status code:');
  //           console.error(error.status);
  //           console.error(error.statusText);

  //           if (error.status === 401) { // token expired
  //             this.handle401(req, next);
  //           }
  //           else { // refresh token has expired
  //             this.loginService.logout();
  //             this.router.navigate(['/login']);
  //           }
  //         })
  //       );
  //   } else {
  //     return next.handle(req);
  //   }
  // }

 
}