import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-home-template',
  templateUrl: './home-template.component.html',
  styleUrls: ['./home-template.component.css']
})
export class HomeTemplateComponent implements OnInit {


  step: String ; 
  constructor() { }

  ngOnInit() {
    this.step = 'home' ; 
  }
 
  
}
