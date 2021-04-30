import { Component, OnInit } from '@angular/core';
import { ColumnMode, SelectionType } from '@swimlane/ngx-datatable';
import { Bill } from 'src/app/_models/Bill';
import { BillDataService } from 'src/app/_service/BillDataService';

@Component({
  selector: 'bill-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  constructor(private billDataService: BillDataService) { }

  rows: Bill[] = [];
  columns = [
    { prop: 'date' },
    { name: 'Service', prop: 'service.type' },
    { name: 'Issue', prop: 'service.jobcard.issues' },
    { prop: 'labourCharges' },
    { prop: 'serviceCharges' },
    { name: 'Customer', prop: 'customer.name' },
    { prop: 'total' }
  ];

  selected = [];
  ColumnMode = ColumnMode;
  SelectionType = SelectionType;

  onSelect({ selected }) {
    console.log('Select Event', selected, this.selected);
  }

  async ngOnInit() {
    const response = await this.billDataService.getAll().toPromise()
    response.forEach(x => x.total = x.labourCharges + x.serviceCharges)
    this.rows = response;
  }
}
