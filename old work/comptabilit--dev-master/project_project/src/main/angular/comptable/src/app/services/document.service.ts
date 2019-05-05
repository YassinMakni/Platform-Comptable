import { Document } from './../models/document.model';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable, observable } from '../../../node_modules/rxjs';
import {ResponseContentType } from '@angular/http';
import { Annee } from '../models/annee';

const httpOptions = {
  headers: new HttpHeaders({ 
    'Content-Type': 'application/json',
    "Access-Control-Allow-Origin": "*",
    "Authorization": "Bearer "
  }), responseType: ResponseContentType.ArrayBuffer 
};

@Injectable()
export class DocumentService {
  
  constructor(private http: HttpClient) { }

  addDocument(file: File, value: any): Observable<HttpEvent<{}>> {

    const formdata: FormData = new FormData();
    /* console.log(file); */
    formdata.append('file', file);
    formdata.append('type', value['type']);
    formdata.append('annee',value['annee']);
    formdata.append('contenue',"");
    const req = new HttpRequest('POST', '/api/client/upload', formdata, {
      reportProgress: true,
      responseType: 'text'
    }
    );
    console.log(formdata);
    return this.http.request(req);
  }
  addAdminDocument(file: File, value: any): Observable<HttpEvent<{}>> {
    console.log(value);
    const formdata: FormData = new FormData();
    /* console.log(file); */
    formdata.append('file', file);
    formdata.append('type', value['type']);
    formdata.append('annee',value['annee']);
    formdata.append('id',value['destination']);
    formdata.append('contenue',"");
    const req = new HttpRequest('POST', '/api/admin/upload', formdata, {
      reportProgress: true,
      responseType: 'text'
    }
    );
    return this.http.request(req);
  }
  addDocumentNewswithFile(file: File, value:any):Observable<HttpEvent<{}>>{
    const formdata: FormData = new FormData();
    /* console.log(file); */
    formdata.append('file', file);
    formdata.append('type', value['type']);
    formdata.append('nomNews', value['nom']);
    console.log(value['contenue']) ; 
    formdata.append('contenue',value['contenue']);
    formdata.append('annee',""); 
    const req = new HttpRequest('POST', '/api/admin/upload/news/file', formdata, {
      reportProgress: true,
      responseType: 'text'
    }
    );
    console.log(formdata);
    return this.http.request(req);
  }
  addDocumentNewswithoutFile(value:any):Observable<HttpEvent<{}>>{
    const formdata: FormData = new FormData();
    formdata.append('type', value['type']);
    formdata.append('nomNews', value['nom']);
    formdata.append('contenue',value['contenue']);
    formdata.append('annee',"");
    const req = new HttpRequest('POST', '/api/admin/upload/News', formdata, {
      reportProgress: true,
      responseType: 'text'
    }
    );
    console.log(formdata);
    return this.http.request(req);
  }
  getFolder(id:number, annee:Annee, folder : string){
    return this.http.get<Observable<Document>>('api/admin/document/'+folder+'/'+annee+'/'+id);
  }
  getDocument(id: number) {
    return this.http.get<Document>('/api/client/document/' + id);
  }
  getDocumentNews(type:String){
    return this.http.get<Document>('/api/admin/document/news/' + type) ; 
  }
  getDossierJuridique(annee:number){
    return this.http.get<Document>('/api/client/document/dossierJuridique/'+annee) ; 
  }
 getBilanAnnuel(annee:number){
  return this.http.get<Document>('/api/client/document/bilanAnnuel/'+annee) ;
 }
 getBilanMensuel(annee:number,mois: String){
  return this.http.get<Document>('/api/client/document/bilanMensuel/'+annee+'/'+mois) ;
 }
 getAllAnnee(){
   return this.http.get<Annee>('/api/client/document/annee') ; 
 }
 getAllAnneeClient(id:number){
  return this.http.get<Observable<Annee>>('/api/admin/document/annee/'+id) ; 
}
 deleteDocument(id:number){
   return this.http.delete('/api/admin/document/delete/'+id) ; 
 }
 openYear(id:number){
   return this.http.get('/api/admin/document/annee/activer/'+id)
 }
 closeYear(id:number){
   return this.http.get('/api/admin/document/annee/cloturer/'+id)
 }
}