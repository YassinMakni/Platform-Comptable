import { Component, Input } from '@angular/core';
import { GlobalService } from '../../services/global.service';
import { TokenStorageService } from '../../services/token-storage.service';
import { User } from '../../models/user';

@Component({
  selector: 'pages-top',
  templateUrl: './pages-top.component.html',
  styleUrls: ['./pages-top.component.scss'],
})
export class PagesTopComponent {
  avatarImgSrc: string = 'assets/images/avatar.png';
  userName: string = 'Mahdi Taghouti';
  userPost: string = 'Administrateur';

  user: User ; 
  sidebarToggle: boolean = true;
  tip = { ring: true, email: true };

  constructor(private _globalService: GlobalService) { 
    
  }

  public _sidebarToggle() {
    //  this._globalService.sidebarToggle$.subscribe(sidebarToggle => {
    //   this.sidebarToggle = sidebarToggle;
    // }, error => {
    //   console.log('Error: ' + error);
    // }); 

    this._globalService.data$.subscribe(data => {
      if (data.ev === 'sidebarToggle') {
        this.sidebarToggle = data.value;
      
      }
    }, error => {
      console.log('Error: ' + error);
    });
    this._globalService.dataBusChanged('sidebarToggle', !this.sidebarToggle);


    //this._globalService._sidebarToggleState(!this.sidebarToggle);
  }
}
