import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../../services/document.service';

@Component({
  selector: 'app-actualite',
  templateUrl: './actualite.component.html',
  styleUrls: ['./actualite.component.css']
})
export class ActualiteComponent implements OnInit {

  private annee: number ; 
  documents: Document[] ; 
  constructor(private documentService: DocumentService) {
      this.documentService.getDocumentNews("actualite").subscribe((result: any) => {
        this.documents = result;
        console.log(result) ; 
      }, error => console.error(error));
   
   }

  ngOnInit() {
  }

}
