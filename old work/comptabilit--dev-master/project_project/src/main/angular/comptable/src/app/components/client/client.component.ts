import { LoginService } from './../../services/login.service';
import { Client } from './../../models/client.model';

import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../services/client.service';



@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {


  constructor(private loginService: LoginService,private clientService : ClientService) {
    
    this.clientService.getClient().subscribe(data =>{
      let client = new Client(data['nom'],data['prenom'],data['email'],data['telephone'],data['nomSociete'],data['matricule'],data['telSociete'],data['numRegistreCommerce'],data['secteurActivite'],data['adresseSociete'],data['emailSociete'],data['validation']);
      this.loginService.storeUser(client)
    })
  }

  ngOnInit() {
  }

}
