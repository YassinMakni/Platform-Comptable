import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '../../../../../node_modules/@angular/router';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../models/client.model';

@Component({
  selector: 'app-profil-client-admin',
  templateUrl: './profil-client-admin.component.html',
  styleUrls: ['./profil-client-admin.component.css']
})
export class ProfilClientAdminComponent implements OnInit {

  id:number;
  client:Client;

  constructor(private route: ActivatedRoute, private clientService : ClientService) { 

    this.route.params.subscribe( params => {
    this.id = params.id ;
    this.clientService.getClientById(this.id).subscribe((result: any) => {
      this.client = result;
      console.log(this.client) ; 
    }, error => console.error(error));
  });
}

  ngOnInit() {
  }



}
