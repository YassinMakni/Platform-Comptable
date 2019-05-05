import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DocumentService } from '../../../../../services/document.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-dossier-juridique',
  templateUrl: './dossier-juridique.component.html',
  styleUrls: ['./dossier-juridique.component.css']
})
export class DossierJuridiqueComponent implements OnInit {

  private annee: number ; 
  documents: Document[] ; 
  constructor(private documentService: DocumentService,private route: ActivatedRoute) {
    this.route.params.subscribe( params => {
      this.annee = params.annee ;
      this.documentService.getDossierJuridique(this.annee).subscribe((result: any) => {
        this.documents = result;
        console.log(this.documents) ; 
      }, error => console.error(error));
    });
   }

  ngOnInit() {
  }
  private showMessage(id: number){
    swal({
      title: 'Êtes-vous sûr?',
      text: 'Vous ne pourrez pas récupérer ce collaborateurfichier!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Oui, supprimez-le!',
      cancelButtonText: 'Non, garde le'
    }).then((result) => {
      if (result.value) {
        this.documentService.deleteDocument(id).subscribe((result: any[]) => {
         console.log("document deleted ! ") ; 
        }, error => console.error(error)) ; 
        swal(
          'Supprimé!',
          'le fichier a été supprimé.',
          'success'
        )
        document.getElementById(id.toString()+'a').style.display = "none";  
      } else if (result.dismiss === swal.DismissReason.cancel) {
        swal(
          'Annulé',
          'le fichier a été conservé',
          'error'
        )
      }
    })
  }
}
