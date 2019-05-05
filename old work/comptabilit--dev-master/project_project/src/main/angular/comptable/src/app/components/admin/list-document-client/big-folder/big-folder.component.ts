import { Annee } from './../../../../models/annee';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-big-folder',
  templateUrl: './big-folder.component.html',
  styleUrls: ['./big-folder.component.css']
})
export class BigFolderComponent implements OnInit {
  id:number;
  annee:Annee;
  constructor(private route : ActivatedRoute) {
    this.route.params.subscribe( params => {
      this.id = params.id ;
      this.annee=params.annee;
    });
   }

  ngOnInit() {
  }

}
