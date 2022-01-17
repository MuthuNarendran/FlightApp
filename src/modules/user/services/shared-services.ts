import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})

export class SharedService {
    bookingData: any;
    id!: number;
    constructor() { }
    setBookingData(data: any) {
        this.bookingData = data;
    }

    getBookingData() {
        return this.bookingData;
    }

    setId(id: number) {
        this.id = id;
    }

    getId() :number {
        return this.id;
    }
}