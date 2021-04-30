import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/_models/customer';
import { CustomerDataService } from 'src/app/_service/CustomerDataService';
import { ColumnMode, SelectionType } from '@swimlane/ngx-datatable';

@Component({
  selector: 'customer-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {
  constructor(private customerDataService: CustomerDataService) {}

  rows: Customer[] = [];
  columns = [
    { naem: 'Name', prop: 'name' },
    { naem: 'Address', prop: 'address' },
    { naem: 'Contact', prop: 'contact' },
  ];

  selected = [];
  ColumnMode = ColumnMode;
  SelectionType = SelectionType;

  onSelect({ selected }) {
    console.log('Select Event', selected, this.selected);
  }

  async ngOnInit() {
    const response = await this.customerDataService.getAll().toPromise();
    this.rows = response;
  }
}
