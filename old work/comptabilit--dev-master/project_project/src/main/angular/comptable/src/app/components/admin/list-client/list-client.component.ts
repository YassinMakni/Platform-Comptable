import { Component, OnInit } from '@angular/core';
import swal from 'sweetalert2';
import { Client } from '../../../models/client.model';
import { ClientService } from '../../../services/client.service';

@Component({
  selector: 'app-list-client',
  templateUrl: './list-client.component.html',
  styleUrls: ['./list-client.component.css']
})
export class ListClientComponent implements OnInit {

  constructor(private clientService: ClientService) { }
  clients: Client[] ; 
  
  ngOnInit() {
    this.clientService.getClientValidation(true).subscribe((result : any[] )=> {
      console.log('client validation: ',result)
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
