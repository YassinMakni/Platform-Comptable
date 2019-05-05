import { Client } from "./client.model";

enum TypeFolder {
	actualite,
	convention,
	dossierJuridique,
	dossierAnnuel,
	Janvier,
	Février,
	Mars,	
	Avril,	
	Mai,	
	Juin,	
	Juillet,	
	Août,
	Septembrer,	
	Octobre,	
	Novembre,	
	Décembre
}
export class Document {

    public id : number;
	constructor (public name: string,public contenue:string,public path:string ,public anneeDeCreation:string ,public type:TypeFolder,public personneRecepteurDocument: Client,public personneEmmeteurDocument: Client,public nomNews: string)
	{}

}
