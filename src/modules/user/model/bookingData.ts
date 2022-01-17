import { Passenger } from "./passenger";

export class BookingData{

    constructor(private name:string,private emailId:string,private economySeats:number,
        private businessSeats:number,private passengers:Passenger[],private businessClassSeatNumber:string[],
        private economyClassSeatNumber:string[],){}
}