import { Customer } from "./customer";
import { JobCard } from "./JobCard";


export class Vehicle {
    id: number;
    regNo: string;
    model: string;
    engineNo: number;
    chasisNo: number;
    customer: Customer;
    jobCards: JobCard[];
}
