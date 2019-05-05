import { Component, OnInit } from '@angular/core';
import { TablesDataService } from '../data-table/tablesData.service';
import { FileService } from '../../../../shared/services/file.service';
import {File} from '../../../../shared/models/file' ; 
import swal from 'sweetalert2';

@Component({
  selector: 'app-list-news',
  templateUrl: './list-news.component.html',
  styleUrls: ['./list-news.component.scss'],
  providers: [TablesDataService,FileService]
})
export class ListNewsComponent implements OnInit {

 

  /* pagination Info */
  pageSize = 10;
  pageNumber = 1;

  files: File[] ; 

  constructor(private _tablesDataService: TablesDataService,private fileService: FileService) { }

  ngOnInit() {
    this.loadData() ;
  }


  pageChanged(pN: number): void {
    this.pageNumber = pN;
  }
  loadData(){
    this.fileService.getDocumentNews("actualite").subscribe((result:any)=>{
      this.files = result ; 
    },error => console.log(error))
  }
  alertConfirm(id) {
    swal({
      title: 'Êtes-vous sûr?',
      text: 'Vous ne pourrez pas revenir en arrière!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Oui, supprimez-le!'
    }).then((result) => {
      if (result.value) {
        this.fileService.deleteFile(id).subscribe((data :any) =>{
          this.loadData() ; 
          swal(
            'Supprimé!',
            'Votre fichier a été supprimé.',
            'success'
          );
        },error =>{
          this.loadData() ; 
          swal(
            'Supprimé!',
            'Votre fichier a été supprimé.',
            'success'
          );
        })
        
      }
    });
  }

}
