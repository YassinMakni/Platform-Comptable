export class AuthLoginInfo {
    email: string;
    motDePasse: string;

    constructor(email: string, motDePasse: string) {
        this.email = email;
        this.motDePasse = motDePasse;
    }
}
