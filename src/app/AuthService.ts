import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})

export class AuthService {
    loggedIn!: boolean;
    constructor() { }
    setLoggedIn(status: boolean) {
        this.loggedIn = status;
    }

    getLoggedIn():boolean {
        return this.loggedIn;
    }
}