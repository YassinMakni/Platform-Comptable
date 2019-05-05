import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../../services/document.service';
import { ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-list-document-convention',
  templateUrl: './list-document-convention.component.html',
  styleUrls: ['./list-document-convention.component.css']
})
export class ListDocumentConventionComponent implements OnInit {

  private annee: number ; 
  documents: Document[] ; 
  constructor(private documentService: DocumentService,private route: ActivatedRoute) {

      this.documentService.getDocumentNews("convention").subscribe((result: any) => {
        this.documents = result;
      }, error => console.error(error));
   
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
