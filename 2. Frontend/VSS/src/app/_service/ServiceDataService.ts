import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractDataService } from './AbstractDataService';
import { Service } from '../_models/Service';


@Injectable({
  providedIn: 'root'
})
export class ServiceDataService extends AbstractDataService<Service> {
  constructor(private http: HttpClient) {
    super('service', http);
  }
}
