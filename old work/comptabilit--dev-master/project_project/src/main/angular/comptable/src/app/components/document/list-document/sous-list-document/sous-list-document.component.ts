import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-sous-list-document',
  templateUrl: './sous-list-document.component.html',
  styleUrls: ['./sous-list-document.component.css']
})
export class SousListDocumentComponent implements OnInit {

  annee: number ; 
  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe( params => {
      this.annee = params.annee ;
    });
   }

  ngOnInit() {
  }

}
