import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../../services/document.service';
import { Annee } from '../../../models/annee';
import { ActivatedRoute } from '../../../../../node_modules/@angular/router';

@Component({
  selector: 'app-list-document-client',
  templateUrl: './list-document-client.component.html',
  styleUrls: ['./list-document-client.component.css']
})
export class ListDocumentClientComponent implements OnInit {
  id : number;
  annees: Annee[] ; 
  constructor(private documentService: DocumentService, private route : ActivatedRoute) { 
    this.route.params.subscribe( params => {
      this.id = params.id ;
      console.log(this.id);
      this.update() ; 
    });
    
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
    this.documentService.getAllAnneeClient(this.id).subscribe((result: any) => {
     
      this.annees = result;
      console.log(this.annees) ; 
    }, error => console.error(error));
  }


}
