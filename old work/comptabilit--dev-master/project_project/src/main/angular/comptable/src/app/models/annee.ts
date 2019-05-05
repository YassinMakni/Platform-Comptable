import { Client } from "./client.model";

export class Annee {
    
    public id: number;
    constructor(public client: Client,public status: boolean,public annee: number){}
        
}
