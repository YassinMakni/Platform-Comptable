import { Component } from '@angular/core';
import { TokenStorageService } from '../shared/services/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.scss'],
  providers:[TokenStorageService,]
})

export class PagesComponent { 
  constructor(private tokenStorage: TokenStorageService,private router: Router){
    if(!this.tokenStorage.getToken())
    {
      this.router.navigate(['/login']);
    }
  }
  ngOnInit() {
  
  }
  
 
}
