import { Client } from "./client.model";

export class Message {
    public id:number ;
    constructor(public contenue:string,public object:string,public lu:boolean,public dateEnvoie:string,public personneEmetteur: Client,public personneRecepteur : Client){} ; 
}
