import { Component, OnInit } from '@angular/core';
import { ColumnMode, SelectionType } from '@swimlane/ngx-datatable';
import { JobCard } from 'src/app/_models/JobCard';
import { JobCardDataService } from 'src/app/_service/JobCardDataService';

@Component({
  selector: 'job-card-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  constructor(private jobCardDataService: JobCardDataService) { }

  rows: JobCard[] = [];
  columns = [
    { prop: 'id' },
    { prop: 'issues' },
    { prop: 'remarks' },
    { name: 'Vehicle Reg No', prop: 'vehicle.regNo' },
    { name: 'Customer', prop: 'vehicle.customer.name' },
    { prop: 'date' }
  ];

  selected = [];
  ColumnMode = ColumnMode;
  SelectionType = SelectionType;

  onSelect({ selected }) {
    console.log('Select Event', selected, this.selected);
  }

  async ngOnInit() {
    const response = await this.jobCardDataService.getAll().toPromise()
    this.rows = response;
  }

}
