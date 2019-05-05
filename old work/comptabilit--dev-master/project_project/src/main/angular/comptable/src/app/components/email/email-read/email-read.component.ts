import { Component, OnInit } from '@angular/core';
import { MessageService } from '../../../services/message.service';
import { Message } from '../../../models/message.model';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-email-read',
  templateUrl: './email-read.component.html',
  styleUrls: ['./email-read.component.css']
})
export class EmailReadComponent implements OnInit {
  message: Message ; 
  id:number;
  constructor(public messageService: MessageService,private route: ActivatedRoute) { 
    this.route.params.subscribe( params => {
      this.id = params.id ;
      this.MessageLu() ; 
      this.messageService.getMessageById(this.id).subscribe((result: any) => {
        this.message = result;
      }, error => console.error(error));
    });
    
  }
  
  
  ngOnInit() {
  }
  
  MessageLu(){
    this.messageService.MessageLu(this.id).subscribe((result: any) => {
      console.log("message lu") ; 
    }, error => console.error(error)); 
  }

}
