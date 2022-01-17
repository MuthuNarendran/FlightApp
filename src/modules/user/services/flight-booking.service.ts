import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class FlightBookingService {

    private flightSearchUrl: string = "http://localhost:8989/api/v1.0/user/flight/search";
    private flightBookingurl: string = "http://localhost:8989/api/v1.0/user/flight/booking/";
    private ticketSearchurl: string = "http://localhost:8989/api/v1.0/user/flight/ticket/";
    private userHistoryUrl: string = "http://localhost:8989/api/v1.0/user/flight/booking/history/";
    private deleteTicketUrl:string ="http://localhost:8989/api/v1.0/user/flight/booking/cancel/"
    constructor(private httpClient: HttpClient) { }

    searchFlights(searchData: any) {
        return this.httpClient.post(this.flightSearchUrl, searchData);
    }

    bookFlights(bookData: any, flightId: number) {
        return this.httpClient.post(this.flightBookingurl + flightId, bookData);
    }

    searchTicketsByPNR(pnr: number) {
        return this.httpClient.get(this.ticketSearchurl + pnr)
    }

    searchTicketsByUserHistory(emailId: number) {
        return this.httpClient.get(this.userHistoryUrl + emailId)
    }

    deleteTicketsByPnr(pnr: number) {
        console.log(this.deleteTicketUrl + pnr)
        return this.httpClient.delete(this.deleteTicketUrl + pnr)
    }
}