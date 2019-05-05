import { DocumentService } from './../../../../services/document.service';
import { Annee } from './../../../../models/annee';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-folder-detail',
  templateUrl: './folder-detail.component.html',
  styleUrls: ['./folder-detail.component.css']
})
export class FolderDetailComponent implements OnInit {

  id : number;
  annee : Annee;
  folder : string;
  documents: Document[] ; 
  typeFolder : string;
  constructor(private documentService: DocumentService,private route: ActivatedRoute) {
    this.route.params.subscribe( params => {
    this.id = params.id ;
    this.annee=params.annee;
    this.folder=params.folder;
    });
    if(["Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembrer","Octobre","Novembre","Décembre"].includes(this.folder)){
      this.typeFolder="Bilon Mensuel";
    }else {
      if (this.folder == "dossierJuridique"){
        this.typeFolder = "Dossier Juridique"
      }else{
        this.typeFolder="Dossier Annuel"
      }
    }
  }
  ngOnInit() {
    this.documentService.getFolder(this.id,this.annee,this.folder).subscribe((result: any) => {
      this.documents = result;
      console.log(this.documents) ; 
    }, error => console.error(error));
  }

}
