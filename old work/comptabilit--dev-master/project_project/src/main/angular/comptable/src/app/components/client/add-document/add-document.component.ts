import { element } from 'protractor';
import { Document } from '../../../models/document.model';
import { DocumentService } from '../../../services/document.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpResponse, HttpEventType } from '@angular/common/http';


@Component({
  selector: 'app-add-document',
  templateUrl: './add-document.component.html',
  styleUrls: ['./add-document.component.css']
})
export class AddDocumentComponent implements OnInit {

  documentForm: FormGroup;
  progress: { percentage: number , varFileName: string  };
  constructor(public documentService: DocumentService) { 
    this.documentForm = new FormGroup({
      annee: new FormControl(),
      type: new FormControl(),
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
  Array.from(this.selectedFiles).forEach(currentFileUpload => { 
    this.documentService.addDocument(currentFileUpload,value).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        currentFileUpload["progress"] = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
     });
   });

 }

}
