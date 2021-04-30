import { Customer } from "./customer";
import { Service } from "./Service";
import { Insurance } from "./Insurance";


export class Bill {
    id: number;
    labourCharges: number;
    serviceCharges: number;
    insurance: Insurance;
    customer: Customer;
    service: Service;
    date: Date;
    total: number

}
