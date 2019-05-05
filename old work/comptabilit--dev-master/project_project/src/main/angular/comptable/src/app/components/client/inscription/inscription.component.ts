import { ClientService } from '../../../services/client.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  clientForm: FormGroup;

  constructor(public clientService: ClientService) { 
    
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
  }) }

  ngOnInit() {
  }

  selectedFiles: FileList;
  progress: { percentage: number , varFileName: string  };

  selectFile(event) {
    this.selectedFiles = undefined;
    this.selectedFiles = event.target.files;
    Array.from(this.selectedFiles).forEach(element => {
      element["progress"] = 0;
    });
  }  
  onSubmit({value,valid}){
    console.log(value);
    this.clientService.addClient(value).subscribe(data =>{
      console.log("goo");
    },error=> console.error(error));
  }
}
