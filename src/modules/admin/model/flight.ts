import { Airline } from "./airline";

export class Flight {
    constructor(private number: number, private airline :Airline , private origin:string ,
        private destination:string , private date:string , private startTime: string ,
        private endTime: string , private scheduledDays: string , private businessSeats: string,
        private economySeats: string , private businessClassSeatNumber : string[],
        private economyClassSeatNumber : string[] , private meals:string , private fare:string 
        ){}
}