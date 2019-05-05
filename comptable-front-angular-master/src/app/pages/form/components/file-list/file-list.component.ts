import { Component, OnInit } from '@angular/core';
import { FileListService } from '../../../../shared/services/file-list.service';
import { FileService } from '../../../../shared/services/file.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-file-list',
  templateUrl: './file-list.component.html',
  styleUrls: ['./file-list.component.scss'],
  providers: [FileService]
})
export class FileListComponent implements OnInit {
    toggler: any; 
    i: number ;
    path : string ; 
    fileUploads:Document[] ;
    //fileUploads: Observable<string[]> 
  constructor(private fileService: FileService) {
    
    this.fileService.getDossierJuridique(2017,1).subscribe((result: any) => {
      this.fileUploads = result;
      this.path = "http://localhost:8088/api/ressources/files/"
      console.log(this.fileUploads) ; 
    }, error => console.error(error));
   }
 
  ngOnInit() {
    this.toggler = document.getElementsByClassName("carett");
    console.log(this.toggler.length) ; 
    for (this.i = 0; this.i < this.toggler.length; this.i++) {
      this.toggler[this.i].addEventListener("click", function() {
        this.parentElement.querySelector(".nested").classList.toggle("active");
        this.classList.toggle("carett-open");
      });
    }
  }


}
