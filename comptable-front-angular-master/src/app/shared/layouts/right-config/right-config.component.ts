import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../../services/global.service';
import { TokenStorageService } from '../../services/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'right-config',
  templateUrl: './right-config.component.html',
  styleUrls: ['./right-config.component.scss']
})
export class RightConfigComponent implements OnInit {

  isConfigToggle: boolean = false;
  connect: boolean = true ; 
  constructor(private _globalService: GlobalService,private router: Router) { }

  ngOnInit() { }

  deconnect(){
    console.log("deconnected! ") ; 
    window.sessionStorage.clear() ; 
    this.connect = false ;
    this.router.navigate(['/login']);
  }
  configToggle() {
    this.isConfigToggle = !this.isConfigToggle;
    //this._globalService._sidebarToggleState(!this.isConfigToggle);
    this._globalService.dataBusChanged('sidebarToggle', !this.isConfigToggle);
  }
}
