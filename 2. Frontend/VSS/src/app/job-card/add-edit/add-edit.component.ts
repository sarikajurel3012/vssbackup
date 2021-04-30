import { Component, OnInit } from '@angular/core';
import { NotifierService } from 'angular-notifier';
import { JobCard } from 'src/app/_models/JobCard';
import { Vehicle } from 'src/app/_models/Vehicle';
import { JobCardDataService } from 'src/app/_service/JobCardDataService';
import { VehicleDataService } from 'src/app/_service/VehicleDataService';

@Component({
  selector: 'job-card-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.scss']
})
export class AddEditComponent implements OnInit {

  constructor(private jobCardDataService: JobCardDataService, private vehicleDataService: VehicleDataService, private notifier: NotifierService) { this.createNewItem() }

  item: JobCard;

  createNewItem() {
    this.item = new JobCard();
    this.item.vehicle = new Vehicle();
  }

  vehicleList: Vehicle[] = []

  async ngOnInit() {
    this.vehicleList = await this.vehicleDataService.getAll().toPromise()
  }

  async onSubmit() {
    try {
      const response = await this.jobCardDataService.post(this.item).toPromise()
      this.notifier.notify('success', 'Created')
      console.log(response);
    } catch (error) {
      console.warn('failed')
    }
    this.createNewItem();
  }

}
