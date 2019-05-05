import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../models/client.model';
import swal from 'sweetalert2' ; 

@Component({
  selector: 'app-list-client-non-valide',
  templateUrl: './list-client-non-valide.component.html',
  styleUrls: ['./list-client-non-valide.component.css']
})
export class ListClientNonValideComponent implements OnInit {

  
  constructor(private clientService: ClientService) { }
  clients: Client[] ; 
  
  ngOnInit() {
    this.clientService.getClientValidation(false).subscribe((result: any[]) => {
      this.clients = result;
    }, error => console.error(error));
  }
  private showMessageSupprime(id_div: string,id:number){
    swal({
      title: 'Êtes-vous sûr?',
      text: 'Vous ne pourrez pas récupérer ce client!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Oui, supprimez-le!',
      cancelButtonText: 'Non, garde le'
    }).then((result) => {
      if (result.value) {
        this.clientService.deleteClient(id).subscribe((result: any[]) => {
         console.log("client deleted ! ") ; 
        }, error => console.error(error)) ; 
        swal(
          'Supprimé!',
          'le client a été supprimé.',
          'success'
        )
        document.getElementById(id_div).style.display = "none";  
      } else if (result.dismiss === swal.DismissReason.cancel) {
        swal(
          'Annulé',
          'client non approuvé',
          'error'
        )
      }
    })
  }

  private showMessageSucess(id_div: string,id:number){
    swal("Nouveau client ajouté avec succées!","", "success") ; 
    this.clientService.approuverClient(id).subscribe((result: any[]) => {
      console.log("client approuved ! ") ; 
     }, error => console.error(error)) ; 
    document.getElementById(id_div).style.display = "none";  
  }

}
