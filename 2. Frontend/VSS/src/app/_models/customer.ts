import { Bill } from "./Bill"
import { Vehicle } from "./Vehicle"

export class Customer {
    id: number
    name: string
    contact: string
    address: string
    vehicles: Vehicle[]
    bills: Bill[]
}