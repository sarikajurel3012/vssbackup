import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractDataService } from './AbstractDataService';
import { Insurance } from '../_models/Insurance';


@Injectable({
  providedIn: 'root'
})
export class InsuranceDataService extends AbstractDataService<Insurance> {
  constructor(private http: HttpClient) {
    super('insurance', http);
  }
}
