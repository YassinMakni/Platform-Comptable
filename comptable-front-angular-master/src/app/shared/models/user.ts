export class User {
    id:number ; 
    name: string;
    username: string;
    email: string;
    password?: string;
    roles: string[];
    constructor(id: number , name: string, username: string, email: string, roles: string[], password?: string) {
        this.id ; 
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles ;
    }
}
