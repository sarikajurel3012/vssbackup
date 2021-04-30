import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../_models/customer';
import { AbstractDataService } from './AbstractDataService';

@Injectable({
  providedIn: 'root'
})
export class CustomerDataService extends AbstractDataService<Customer> {

  constructor(private http: HttpClient) {
    super("customer", http)
  }
}
