export class Client {
    
    public id: number;
    constructor(public nom: string, public prenom: string, public email: string, 
        public telephone: string, public nomSociete: string,
        public matricule: string, public telSociete: string, public numRegistreCommerce: string, public secteurActivite: string,
        public adresseSociete: string, public emailSociete: string, public validation: boolean, public motDePasse?: string){}
        
}
