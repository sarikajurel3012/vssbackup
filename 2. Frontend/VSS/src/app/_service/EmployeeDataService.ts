import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractDataService } from './AbstractDataService';
import { Employee } from '../_models/Employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeDataService extends AbstractDataService<Employee> {
  constructor(private http: HttpClient) {
    super('employee', http);
  }
}
