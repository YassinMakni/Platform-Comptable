import { Component, OnInit, Input } from '@angular/core';
import { Client } from '../../../models/client.model';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {
 
  @Input() client: Client ;
  clientEdit: Client ; 
  clientForm: FormGroup;
   
  constructor() {
    this.clientForm = new FormGroup({
      nom: new FormControl(),
      prenom: new FormControl(),
      email: new FormControl(),
      motDePasse: new FormControl(),
      telephone:new FormControl(),
      nomSociete: new FormControl(),
      adresseSociete: new FormControl(),
      telSociete: new FormControl(),
      matricule: new FormControl(),
      numRegistreCommerce: new FormControl(),
      emailSociete: new FormControl(),
      secteurActivite: new FormControl(),
    }) 
   }

  ngOnInit() {
    this.clientEdit = this.client ;
  }

}
