import { Passenger } from "./passenger";

export class Booking{
    constructor(private pnr:number,private name:string,private flightId:number,private airlineName:string,
        private depatureTime:string, private endTime:string, private date:string, private source:string ,
        private destination:string , private businessSeat:string , private economySeat:string , private emailId:string,
        private businessClassSeatNumber:string[] , private economyClassSeatNumber:String[], private passenger:Passenger[])
        {}
}