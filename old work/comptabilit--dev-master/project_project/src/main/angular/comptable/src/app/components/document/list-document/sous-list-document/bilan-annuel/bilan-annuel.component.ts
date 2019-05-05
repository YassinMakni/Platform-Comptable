import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../../../../services/document.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bilan-annuel',
  templateUrl: './bilan-annuel.component.html',
  styleUrls: ['./bilan-annuel.component.css']
})
export class BilanAnnuelComponent implements OnInit {

  private annee: number ; 
  documents: Document[] ; 
  constructor(private documentService: DocumentService,private route: ActivatedRoute) {
    this.route.params.subscribe( params => {
      this.annee = params.annee ;
      this.documentService.getBilanAnnuel(this.annee).subscribe((result: any) => {
        this.documents = result;
        console.log(this.documents) ; 
      }, error => console.error(error));
    });
   }

  ngOnInit() {
  }

}
