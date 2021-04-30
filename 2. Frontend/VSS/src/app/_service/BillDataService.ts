import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractDataService } from './AbstractDataService';
import { Bill } from '../_models/Bill';


@Injectable({
  providedIn: 'root'
})
export class BillDataService extends AbstractDataService<Bill> {
  constructor(private http: HttpClient) {
    super('bill', http);
  }
}
