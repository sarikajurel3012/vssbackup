import { Component, OnInit } from '@angular/core';
import { NotifierService } from 'angular-notifier';
import { Employee } from 'src/app/_models/Employee';
import { JobCard } from 'src/app/_models/JobCard';
import { Service } from 'src/app/_models/Service';
import { EmployeeDataService } from 'src/app/_service/EmployeeDataService';
import { JobCardDataService } from 'src/app/_service/JobCardDataService';
import { ServiceDataService } from 'src/app/_service/ServiceDataService';

@Component({
  selector: 'app-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.scss']
})
export class AddEditComponent implements OnInit {

  constructor(private serviceDataService: ServiceDataService, private jobCardDataService: JobCardDataService, private employeeDataService: EmployeeDataService, private notifier: NotifierService) { this.createNewItem() }
  async ngOnInit() {
    this.jobCardList = await this.jobCardDataService.getAll().toPromise();
    console.log(this.jobCardList);

    this.employeeList = await this.employeeDataService.getAll().toPromise();
    console.log(this.employeeList);
  }

  createNewItem() {
    this.item = new Service();
    this.item.jobcard = new JobCard();
    this.item.employee = new Employee();
  }

  item: Service;

  jobCardList: JobCard[] = []
  employeeList: Employee[] = []

  async onSubmit() {
    console.log(this.item);
    try {
      const response = await this.serviceDataService.post(this.item).toPromise()
      this.notifier.notify('success', 'Created')
      console.log(response);
    } catch (error) {
      console.warn('failed')
    }
    this.createNewItem();
  }
}
