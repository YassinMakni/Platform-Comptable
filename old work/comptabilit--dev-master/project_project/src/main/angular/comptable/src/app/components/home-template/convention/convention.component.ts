import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../../services/document.service';

@Component({
  selector: 'app-convention',
  templateUrl: './convention.component.html',
  styleUrls: ['./convention.component.css']
})
export class ConventionComponent implements OnInit {

  private annee: number ; 
  documents: Document[] ; 
  constructor(private documentService: DocumentService) {
      this.documentService.getDocumentNews("convention").subscribe((result: any) => {
        this.documents = result;
        console.log(result) ; 
      }, error => console.error(error));
   
   }

  ngOnInit() {
  }


}
