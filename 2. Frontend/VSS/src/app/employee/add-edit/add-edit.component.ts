import { Component } from '@angular/core';
import { NotifierService } from 'angular-notifier';
import { Employee } from 'src/app/_models/Employee';
import { EmployeeDataService } from 'src/app/_service/EmployeeDataService';

@Component({
  selector: 'employee-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.scss']
})
export class AddEditComponent {

  constructor(private employeeDataService: EmployeeDataService, private notifier: NotifierService) { this.createNewItem() }

  createNewItem() {
    this.item = new Employee();
  }

  item: Employee;

  async onSubmit() {
    console.log(this.item);
    try {
      const response = await this.employeeDataService.post(this.item).toPromise()
      this.notifier.notify('success', 'Created')
      console.log(response);
    } catch (error) {
      console.warn('failed')
    }
    this.createNewItem();
  }
}
