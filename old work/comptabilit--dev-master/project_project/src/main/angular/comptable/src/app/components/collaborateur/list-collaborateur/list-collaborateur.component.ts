import { Component, OnInit } from '@angular/core';
import { CollaborateurService } from '../../../services/collaborateur.service';
import { Collaborateur } from '../../../models/collaborateur.model';
import swal from 'sweetalert2' ; 

@Component({
  selector: 'app-list-collaborateur',
  templateUrl: './list-collaborateur.component.html',
  styleUrls: ['./list-collaborateur.component.css']
})
export class ListCollaborateurComponent implements OnInit {

  constructor(private collaborateurService: CollaborateurService) { }
  collaborateurs: Collaborateur[];
  ngOnInit() {
    this.collaborateurService.getAllCollaborateurs().subscribe((result: any[]) => {
      this.collaborateurs = result;
    }, error => console.error(error));
  }

  private showMessage(id: number){
    swal({
      title: 'Êtes-vous sûr?',
      text: 'Vous ne pourrez pas récupérer ce collaborateur!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Oui, supprimez-le!',
      cancelButtonText: 'Non, garde le'
    }).then((result) => {
      if (result.value) {
        // this.collaborateurService.deleteCollaborateur(id).subscribe((result: any[]) => {
        //  console.log("collaborateur deleted ! ") ; 
        // }, error => console.error(error)) ; 
        swal(
          'Supprimé!',
          'le collaborateur a été supprimé.',
          'success'
        )
        document.getElementById(id.toString()).style.display = "none";  
      } else if (result.dismiss === swal.DismissReason.cancel) {
        swal(
          'Annulé',
          'le collaborateur a été conservé',
          'error'
        )
      }
    })
  }


}
