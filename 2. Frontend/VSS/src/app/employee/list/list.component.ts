import { Component, OnInit } from '@angular/core';
import { ColumnMode, SelectionType } from '@swimlane/ngx-datatable';
import { Employee } from 'src/app/_models/Employee';
import { EmployeeDataService } from 'src/app/_service/EmployeeDataService';

@Component({
  selector: 'employee-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  constructor(private employeeDataService: EmployeeDataService) { }

  rows: Employee[] = [];
  columns = [
    { prop: 'name' },
    { prop: 'contact' },
    { prop: 'type' },
    { prop: 'doj' },
  ];

  selected = [];
  ColumnMode = ColumnMode;
  SelectionType = SelectionType;

  onSelect({ selected }) {
    console.log('Select Event', selected, this.selected);
  }

  async ngOnInit() {
    const response = await this.employeeDataService.getAll().toPromise()
    this.rows = response;
  }

}
