import { Component, OnInit } from '@angular/core';
import { NotifierService } from 'angular-notifier';
import { Customer } from 'src/app/_models/customer';
import { CustomerDataService } from 'src/app/_service/CustomerDataService';

@Component({
  selector: 'customer-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.scss']
})
export class AddEditComponent {

  constructor(private customerDataService: CustomerDataService, private notifier: NotifierService) { this.createNewItem() }

  item: Customer

  createNewItem() {
    this.item = new Customer();
  }

  async onSubmit() {
    try {
      const response = await this.customerDataService.post(this.item).toPromise()
      this.notifier.notify('success', 'Created')
      console.log(response);
    } catch (error) {
      console.warn('failed')
    }
    this.createNewItem();
  }

}
