import { Component, OnInit } from '@angular/core';
import { MessageService } from '../../../services/message.service';
import { Message } from '../../../models/message.model';

@Component({
  selector: 'app-email-inbox',
  templateUrl: './email-inbox.component.html',
  styleUrls: ['./email-inbox.component.css']
})
export class EmailInboxComponent implements OnInit {

  messages: any[] ; 
  constructor(public messageService: MessageService) { }

  ngOnInit() {
    this.messageService.getMessageByClient().subscribe((result: any[]) => {
      this.messages = result;
      console.log(this.messages) ; 
    }, error => console.error(error));
  }

}
