import { Vehicle } from "./Vehicle";
import { Service } from "./Service";


export class JobCard {
    id: number;
    service: Service;
    issues: string;
    remarks: string;
    vehicle: Vehicle;
    date: Date;
}
