import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Message } from '../models/message.model';
import { ClientService } from './client.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class MessageService {


  constructor(private http: HttpClient,public clientService: ClientService) { }

  addMessage(message: Message){
    return this.http.post<Message>('/api/client/message/create', message);
  }

  getMessageByClient(){
    return this.http.get('/api/client/message/reception/view/all') ; 
  }

  getMessageById(id:number){
    return this.http.get<Message>('/api/client/message/view/'+id);
  }

  MessageLu(id: number){
    return this.http.get('/api/client/message/lu/'+id) ; 
  }

}
