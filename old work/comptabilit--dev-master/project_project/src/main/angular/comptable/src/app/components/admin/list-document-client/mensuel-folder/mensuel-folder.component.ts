import { Annee } from './../../../../models/annee';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mensuel-folder',
  templateUrl: './mensuel-folder.component.html',
  styleUrls: ['./mensuel-folder.component.css']
})
export class MensuelFolderComponent implements OnInit {

  id : number;
  annee : Annee;
  constructor(private route : ActivatedRoute) {
    this.route.params.subscribe( params => {
      this.id = params.id ;
      this.annee=params.annee;
    });
   }

  ngOnInit() {
  }

}
