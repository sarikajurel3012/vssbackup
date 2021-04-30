import { Component, OnInit } from '@angular/core';
import { ColumnMode, SelectionType } from '@swimlane/ngx-datatable';
import { Vehicle } from 'src/app/_models/Vehicle';
import { VehicleDataService } from 'src/app/_service/VehicleDataService';

@Component({
  selector: 'vehicle-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  constructor(private vehicleDataService: VehicleDataService) { }

  rows: Vehicle[] = [];
  columns = [
    { prop: 'regNo' },
    { prop: 'model' },
    { prop: 'engineNo' },
    { prop: 'chasisNo' },
    { name: 'Customer', prop: 'customer.name' }
  ];

  selected = [];
  ColumnMode = ColumnMode;
  SelectionType = SelectionType;

  onSelect({ selected }) {
    console.log('Select Event', selected, this.selected);
  }

  async ngOnInit() {
    const response = await this.vehicleDataService.getAll().toPromise()
    this.rows = response;
  }

}
