import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { MessageService } from '../../../services/message.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Client } from '../../../models/client.model';
import { ClientService } from '../../../services/client.service';
import swal from 'sweetalert2' ; 
declare var jquery:any;
declare var $ :any;

@Component({
  selector: 'app-email-compose-client',
  templateUrl: './email-compose-client.component.html',
  styleUrls: ['./email-compose-client.component.css']
})
export class EmailComposeClientComponent implements OnInit {

  messageForm: FormGroup ;
  emmeteur: Client ; 
  recepteur: Client ; 
  constructor(public messageService: MessageService,public clientService: ClientService) {
    this.messageForm = new FormGroup({
      object: new FormControl(),
      contenue: new FormControl()
    })
   }

  ngOnInit() {
  }

  onSubmit({value,valid}){

    this.messageService.addMessage(value).subscribe(data =>{
      swal("Message envoyé!","", "success") ; 
      this.vider() ; 
    },error=> console.error(error));
  }
  vider(){
   $('#object').val('') ; 
   $('#contenue').val('') ; 
  }

}
