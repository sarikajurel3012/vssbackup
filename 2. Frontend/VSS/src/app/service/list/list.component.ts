import { Component, OnInit } from '@angular/core';
import { ColumnMode, SelectionType } from '@swimlane/ngx-datatable';
import { Service } from 'src/app/_models/Service';
import { ServiceDataService } from 'src/app/_service/ServiceDataService';

@Component({
  selector: 'service-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  constructor(private serviceDataService: ServiceDataService) { }

  rows: Service[] = [];
  columns = [
    { prop: 'jobcard.id' },
    { prop: 'jobcard.issues' },
    { prop: 'type' },
    { name: 'Customer', prop: 'jobcard.vehicle.customer.name' },
    { name: 'Employee', prop: 'employee.name' },
    { prop: 'date' }
  ];

  selected = [];
  ColumnMode = ColumnMode;
  SelectionType = SelectionType;

  onSelect({ selected }) {
    console.log('Select Event', selected, this.selected);
  }

  async ngOnInit() {
    const response = await this.serviceDataService.getAll().toPromise()
    this.rows = response;
  }

}
