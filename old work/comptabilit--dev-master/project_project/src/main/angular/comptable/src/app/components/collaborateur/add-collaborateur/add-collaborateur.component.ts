import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { CollaborateurService } from '../../../services/collaborateur.service';

@Component({
  selector: 'app-add-collaborateur',
  templateUrl: './add-collaborateur.component.html',
  styleUrls: ['./add-collaborateur.component.css']
})
export class AddCollaborateurComponent implements OnInit {

  collaborateurForm: FormGroup;

  constructor(public collaborateurService: CollaborateurService) { 
    
    this.collaborateurForm = new FormGroup({
    nom: new FormControl(),
    prenom: new FormControl(),
    email: new FormControl(),
    motDePasse: new FormControl(),
    telephone:new FormControl()
  }) }

  ngOnInit() {
  }

  onSubmit({value,valid}){
    console.log(value);
    this.collaborateurService.addCollaborateur(value).subscribe(
      data =>{
      console.log("sucess ! collaborateur inserted");
    },error=> console.error(error));
  }
}
