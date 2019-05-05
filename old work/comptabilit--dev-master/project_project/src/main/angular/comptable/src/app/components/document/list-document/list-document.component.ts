import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../../services/document.service';
import { Annee } from '../../../models/annee';

@Component({
  selector: 'app-list-document',
  templateUrl: './list-document.component.html',
  styleUrls: ['./list-document.component.css']
})
export class ListDocumentComponent implements OnInit {

  annees: Annee[] ; 
  constructor(private documentService: DocumentService) { 
    this.update() ; 
  }

  ngOnInit() {
  }
  cloturer(id:number){
    this.documentService.closeYear(id).subscribe((result: any) => {
      this.update() ; 
    }, error => console.error(error));
  }
  activer(id:number){
    this.documentService.openYear(id).subscribe((result: any) => {
      this.update() ; 
    }, error => console.error(error));
  }
  update(){
    this.documentService.getAllAnnee().subscribe((result: any) => {
      this.annees = result;
    }, error => console.error(error));
  }

}
