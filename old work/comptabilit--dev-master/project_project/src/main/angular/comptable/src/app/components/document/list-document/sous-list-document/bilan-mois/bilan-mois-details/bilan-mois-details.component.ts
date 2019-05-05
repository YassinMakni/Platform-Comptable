import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../../../../../services/document.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bilan-mois-details',
  templateUrl: './bilan-mois-details.component.html',
  styleUrls: ['./bilan-mois-details.component.css']
})
export class BilanMoisDetailsComponent implements OnInit {

  private annee: number ; 
  private mois: String ; 
  documents: Document[] ; 
  constructor(private documentService: DocumentService,private route: ActivatedRoute) {
    this.route.params.subscribe( params => {
      this.annee = params.annee ;
      this.mois = params.mois ;
      this.documentService.getBilanMensuel(this.annee,this.mois).subscribe((result: any) => {
        this.documents = result;
        console.log(this.documents) ; 
      }, error => console.error(error));
    });
   }
  ngOnInit() {
  }

}
