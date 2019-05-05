import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpRequest, HttpEvent } from '../../../../node_modules/@angular/common/http';
import { Observable } from '../../../../node_modules/rxjs/Observable';
import { ResponseContentType } from '../../../../node_modules/@angular/http';

const httpOptions = {
  headers: new HttpHeaders({ 
    'Content-Type': 'application/json'
  }), responseType: ResponseContentType.ArrayBuffer 
};

@Injectable()
export class FileService {

  constructor(private http: HttpClient) { }

  addFileAdmin(data: FormData): Observable<HttpEvent<{}>>{
    const req = new HttpRequest('POST', '/api/admin/upload/news/file', data, {
      reportProgress: true,
      responseType: 'text'
    }
    );
    console.log(data);
    return this.http.request(req);
  }
  // getDossierJuridique(annee:number,id:number){
  //   return this.http.get('/api/admin/document/dossierJuridique/'+annee+'/'+id) ;
    
  // }
  getDossierJuridique(annee:number,id:number){
    return this.http.get<Document>('/api/admin/document/dossierJuridique/'+annee+'/'+id) ;
    
  }
  getDocument(id: number) {
    return this.http.get<Document>('/api/admin/document/' + id);
  }
  getDocumentNews(type:String){
    return this.http.get<Document>('http://localhost:8088/api/ressources/document/news/' + type) ; 
  }
  deleteFile(id:number){
    return this.http.get('http://localhost:8088/api/admin/document/delete/'+id) ; 
  }
  // getFiles(): Observable<string[]> {
  //   return this.http.get('/api/admin/getallfiles') ; 
  // }
}