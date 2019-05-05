import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Collaborateur } from '../models/collaborateur.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CollaborateurService {

  constructor(private http: HttpClient) { }

  addCollaborateur(collaborateur) {
    return this.http.post<Collaborateur>('/api/collaborateur/add', collaborateur);
  }

  getCollaborateur(id: string) {
    return this.http.get<Collaborateur>('/api/collaborateur/' + id);
  }

  deleteCollaborateur(id: number){
    return this.http.delete('/api/collaborateur/delete/'+id) ; 
  }
  getAllCollaborateurs(){
    return this.http.get("/api/collaborateur/getAll");
  }
}
