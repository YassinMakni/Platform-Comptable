import { Client } from "./client.model";
enum TypeNotification {
    message,
    document,
    payement
}
export class Notification {
    public id: number ; 
    constructor(public contenue: String,public idObject: number,public vu: Boolean,public dateCreation: String,public personne: Client,public typeNotification: TypeNotification){}
}
