import { ClientService } from './../../../services/client.service';
import { NotificationService } from './../../../services/notification.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../../services/login.service';

@Component({
  selector: 'app-navbar-client',
  templateUrl: './navbar-client.component.html',
  styleUrls: ['./navbar-client.component.css']
})
export class NavbarClientComponent implements OnInit {

  notificationsMessage: Notification[] ; 
  notifications: Notification[] ; 
  constructor(private router:Router,private notificationService: NotificationService,private clientService:ClientService, private loginService : LoginService) { 
    // setInterval(() => {
    //   this.notificationService.getNotification(1,'document').subscribe((result: any[]) => {
    //     this.notifications = result;
    //   }, error => console.error(error));
    //   this.notificationService.getNotification(1,'message').subscribe((result: any[]) => {
    //     this.notificationsMessage = result;
    //   }, error => console.error(error));
    // }, 1000);
  }
  ngOnInit() {}
  redirect(idMessage:number,idNotification){
    this.notificationService.deleteNotification(idNotification).subscribe((result: any) => {
   console.log('notification vu') ; 
    }, error => console.error(error));
    this.router.navigateByUrl('client/email-read/'+idMessage) ; 
  }
  logout(){
    this.loginService.logout();
  }
}
