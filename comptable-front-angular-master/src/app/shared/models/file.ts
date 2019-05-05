import { Client } from "./client";

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
export class File {

    public id : number;
	constructor (public name: string,public nomNews:string,public contenue:string,public path:string ,public anneeDeCreation:string ,public type:TypeFolder,public personneRecepteurDocument: Client,public personneEmmeteurDocument: Client)
	{}

}
