import { Component, OnInit } from '@angular/core';
import { FileUploader } from 'ng2-file-upload';
import { FormGroup,FormControl, FormBuilder, FormsModule, Validators } from '../../../../../../node_modules/@angular/forms';
import { FileService } from '../../../../shared/services/file.service';
import { HttpEventType, HttpResponse } from '../../../../../../node_modules/@angular/common/http';
import { RootComponent } from '../../../../shared/roots/root.component';
import { GlobalService } from '../../../../shared/services/global.service';

const URL = 'https://evening-anchorage-3159.herokuapp.com/api/';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.scss'],
  providers: [FileService]
})
export class FileUploadComponent extends RootComponent implements OnInit {

  public uploadForm: FormGroup ; 
  public uploader: FileUploader = new FileUploader({ url: URL });
  public hasBaseDropZoneOver: boolean = false;
  public hasAnotherDropZoneOver: boolean = false;
  nom: string ; 
  description: string = ""; 
  type: string ;
  defaultContent = "" ; 

  constructor( public fileService: FileService,public _globalService: GlobalService) { 
    super(_globalService);
  }

  ngOnInit() { }
 
 

  public fileOverBase(e: any): void {
    this.hasBaseDropZoneOver = e;
  }

  public fileOverAnother(e: any): void {
    this.hasAnotherDropZoneOver = e;
  }
  onContentChange(event: string) {
    this.description = event ; 
  }
  notification(type) {
    if(type == 'success'){
      this.alertMessage(
        {
          type: type,
          title: 'Succeé!',
          value: 'Document ajouté avec succée.'
        }
        
      );
    }else{
      this.alertMessage(
        {
          type: type,
          title: 'Erreur!',
          value: 'un probléme c\'est produit veuillez réessayer.'
        }
        
      );
    }
    
  }
  uploadSubmit(){
    // for (let j = 0; j < this.uploader.queue.length; j++) {
    //   let data = new FormData();
    //   let fileItem = this.uploader.queue[j]._file;
    //   console.log(fileItem.name); 
    //   data.append('file', fileItem);
    //   data.append('annee','2017') ; 
    //   data.append('contenue','') ; 
    //   data.append('type','dossierJuridique') ; 
    //   data.append('id','1') ; 
     
    //   this.upload(data);
    // }
      let data = new FormData();
      let fileItem = this.uploader.queue[0]._file;
      console.log(fileItem.name); 
      data.append('file', fileItem);
      data.append('contenue',this.description) ; 
      data.append('type',this.type) ; 
      data.append('nomNews',this.nom) ; 
      this.upload(data);
    
   }
   upload(data: FormData){

      this.fileService.addFileAdmin(data).subscribe(event => {
          this.description = '' ; 
          this.nom = '' ; 
          this.notification('success') ; 
          this.uploader.clearQueue();
          console.log('File is completely uploaded!');    
       }),error=> {
        this.notification('danger') ; 
        console.log('erreur')  ; 
       };
     
   }
  
}
