import { Component, OnInit } from '@angular/core';
import { NotifierService } from 'angular-notifier';
import { Customer } from 'src/app/_models/customer';
import { Vehicle } from 'src/app/_models/Vehicle';
import { CustomerDataService } from 'src/app/_service/CustomerDataService';
import { VehicleDataService } from 'src/app/_service/VehicleDataService';

@Component({
  selector: 'vehicle-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.scss']
})
export class AddEditComponent implements OnInit {

  constructor(private vehicleDataService: VehicleDataService, private customerDataService: CustomerDataService, private notifier: NotifierService) { this.createNewItem() }
  async ngOnInit() {
    this.customerList = await this.customerDataService.getAll().toPromise();
    console.log(this.customerList);
  }

  createNewItem() {
    this.item = new Vehicle();
    this.item.customer = new Customer();
  }

  item: Vehicle;

  customerList: Customer[] = []

  async onSubmit() {
    console.log(this.item);
    try {
      const response = await this.vehicleDataService.post(this.item).toPromise()
      this.notifier.notify('success', 'Created')
      console.log(response);
    } catch (error) {
      console.warn('failed')
    }
    this.createNewItem();
  }
}
