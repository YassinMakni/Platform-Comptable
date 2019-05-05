import { Observable, observable } from 'rxjs';
import { Client } from '../models/client.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEvent, HttpRequest } from '@angular/common/http';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ClientService {

  constructor(private http: HttpClient) { }

  // addClient(file: File, client): Observable<HttpEvent<{}>> {

  //   const formdata: FormData = new FormData();
  //   /* console.log(file); */
  //   formdata.append('file', file);
  //   formdata.append('client', client);
  //   const req = new HttpRequest('POST', '/api/client/add', formdata, {
  //     reportProgress: true,
  //     responseType: 'text'
  //   }
  //   );
  //   console.log(formdata);
  //   return this.http.request(req);
  // }
  addClient(client){
    return this.http.post<Client>('/api/client/add', client);
  }
  getClient() {
    return this.http.get('/api/client/get');
}
  getClientById(id: number) {
    return this.http.get<Client>('/api/admin/client/view/' + id);
  }

  getClientValidation(valide: Boolean){
    return this.http.get('/api/admin/client/validation/' + valide) ; 
  }
  getAllClients(){
    return this.http.get<Observable<Client>>("/api/admin/getAllClient");
  }
  deleteClient(id:number){
    return this.http.delete("/api/admin/client/delete/"+id) ; 
  }
  approuverClient(id:number){
    return this.http.get("/api/admin/client/approuver/"+id)
  }
  desapprouverClient(id:number){
    return this.http.get("/api/admin/client/desapprouver/"+id)
  }
}
