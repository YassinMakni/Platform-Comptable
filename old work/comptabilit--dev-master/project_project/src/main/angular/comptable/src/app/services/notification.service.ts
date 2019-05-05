import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { ClientService } from './client.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient,public clientService: ClientService) { }

  getNotification(type: String){
    return this.http.get('/api/client/notification/'+type) ; 
  }
  vuNotification(id: number){
    return this.http.get('api/client/notification/vu/'+id) ; 
  }
  deleteNotification(id: number){
    return this.http.get('api/client/notification/delete/'+id) ; 
  }
}
