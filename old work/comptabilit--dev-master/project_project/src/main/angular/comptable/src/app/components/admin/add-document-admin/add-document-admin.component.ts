import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '../../../../../node_modules/@angular/forms';
import { DocumentService } from '../../../services/document.service';
import { HttpEventType, HttpResponse } from '../../../../../node_modules/@angular/common/http';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../models/client.model';

@Component({
  selector: 'app-add-document-admin',
  templateUrl: './add-document-admin.component.html',
  styleUrls: ['./add-document-admin.component.css']
})
export class AddDocumentAdminComponent implements OnInit {

  documentForm: FormGroup;
  progress: { percentage: number , varFileName: string  };
  constructor(public documentService: DocumentService, private clientService : ClientService) { 
    this.documentForm = new FormGroup({
      annee: new FormControl(),
      type: new FormControl(),
      destination : new FormControl()
    })
  }
  clients: Client[] ; 
  
  ngOnInit() {
    this.clientService.getClientValidation(true).subscribe((result: any[]) => {
      this.clients = result;
    }, error => console.error(error));
  }
  selectedFiles: FileList;
 
  
  selectFile(event) {
   this.selectedFiles = undefined;
   this.selectedFiles = event.target.files;
   Array.from(this.selectedFiles).forEach(element => {
     element["progress"] = 0;
   });
 
  }

  upload({value,valid}) {
    Array.from(this.selectedFiles).forEach(currentFileUpload => { 
      this.documentService.addAdminDocument(currentFileUpload,value).subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
          currentFileUpload["progress"] = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          console.log('File is completely uploaded!');
        }
       });
     });
  
   }
}
