import { Component, OnInit, Pipe, PipeTransform  } from '@angular/core';
import { FileService } from '../../../../shared/services/file.service';
import { ActivatedRoute } from '../../../../../../node_modules/@angular/router';
import { DomSanitizer, SafeHtml, SafeStyle, SafeScript, SafeUrl, SafeResourceUrl } from '@angular/platform-browser';
import { Observable } from 'rxjs/Observable';

@Pipe({
  name: 'safe'
})
@Component({
  selector: 'app-file-view',
  templateUrl: './file-view.component.html',
  styleUrls: ['./file-view.component.scss'],
  providers: [FileService]
})
export class FileViewComponent implements OnInit {

  id: number ; 
  document: Document ; 
  path: string ; 
  constructor(private fileService: FileService,private route: ActivatedRoute) { 

    this.route.params.subscribe( params => {
      this.id = params.id ;
    });
    this.fileService.getDocument(this.id).subscribe((result: any) => {
      this.document = result;
      console.log(this.document) ;  
       this.path = 'http://localhost:4200/files/'; 
      // this.document
    }, error => console.error(error));

  }

  ngOnInit() {
  }

}
