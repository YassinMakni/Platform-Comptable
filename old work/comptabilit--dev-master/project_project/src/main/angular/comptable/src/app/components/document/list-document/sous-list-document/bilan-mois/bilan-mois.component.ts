import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bilan-mois',
  templateUrl: './bilan-mois.component.html',
  styleUrls: ['./bilan-mois.component.css']
})
export class BilanMoisComponent implements OnInit {

  private annee: number ; 
  
  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe( params => {
      this.annee = params.annee  ; 
    });
   }

  ngOnInit() {
  }

}
