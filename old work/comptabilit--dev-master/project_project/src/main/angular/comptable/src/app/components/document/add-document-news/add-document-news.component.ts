import { Component, OnInit, Input } from '@angular/core';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { FormGroup, FormControl } from '@angular/forms';
import { DocumentService } from '../../../services/document.service';

@Component({
  selector: 'app-add-document-news',
  templateUrl: './add-document-news.component.html',
  styleUrls: ['./add-document-news.component.css']
})
export class AddDocumentNewsComponent implements OnInit {

 
  
  documentForm: FormGroup;
  progress: { percentage: number , varFileName: string  };
  constructor(public documentService: DocumentService) { 
    this.documentForm = new FormGroup({
      contenue: new FormControl(),
      type: new FormControl()
    })
  }

  ngOnInit() {
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
  if(!this.selectedFiles) {
    console.log(value['contenue']) ; 
    this.documentService.addDocumentNewswithoutFile(value).subscribe((result: any) => {
     console.log("super ! ") ; 
    }, error => console.error(error)) ;
  }else{
    Array.from(this.selectedFiles).forEach(currentFileUpload => { 
      this.documentService.addDocumentNewswithFile(currentFileUpload,value).subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
          currentFileUpload["progress"] = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          console.log('File is completely uploaded!');
        }
       });
     });
  
  }
   

 }

 


}
