import { Component, OnInit } from '@angular/core';
import { ChartsService } from '../charts/components/echarts/charts.service';
import { TokenStorageService } from '../../shared/services/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss'],
  providers: [
    ChartsService,
    TokenStorageService
  ]
})
export class IndexComponent implements OnInit {
  showloading: boolean = false;

  public AnimationBarOption;

  constructor(private _chartsService: ChartsService,private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    console.log(this.tokenStorage.getToken()) ; 
    this.AnimationBarOption = this._chartsService.getAnimationBarOption();
  }
}
