import { Component, OnInit } from '@angular/core';
import { NotifierService } from 'angular-notifier';
import { Bill } from 'src/app/_models/Bill';
import { Customer } from 'src/app/_models/customer';
import { Service } from 'src/app/_models/Service';
import { BillDataService } from 'src/app/_service/BillDataService';
import { CustomerDataService } from 'src/app/_service/CustomerDataService';
import { ServiceDataService } from 'src/app/_service/ServiceDataService';

@Component({
  selector: 'app-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.scss']
})
export class AddEditComponent implements OnInit {

  constructor(private billDataService: BillDataService, private serviceDataService: ServiceDataService, private notifier: NotifierService) { this.createNewItem() }
  async ngOnInit() {
    this.serviceList = await this.serviceDataService.getAll().toPromise();
    console.log(this.serviceList);
  }

  createNewItem() {
    this.item = new Bill();
    this.item.customer = new Customer();
    this.item.service = new Service();
  }

  item: Bill;

  serviceList: Service[] = []

  async onSubmit() {
    console.log(this.item);    
    this.item.customer.id = this.serviceList.filter(x => x.id == this.item.service.id)[0].jobcard.vehicle.customer.id
    try {
      const response = await this.billDataService.post(this.item).toPromise()
      this.notifier.notify('success', 'Created')
      console.log(response);
    } catch (error) {
      this.notifier.notify('error', 'Failed')
    }
    this.createNewItem();
  }
}
