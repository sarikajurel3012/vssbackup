import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Vehicle } from '../_models/Vehicle';
import { AbstractDataService } from './AbstractDataService';


@Injectable({
  providedIn: 'root'
})
export class VehicleDataService extends AbstractDataService<Vehicle> {
  constructor(private http: HttpClient) {
    super('vehicle', http)
  }
}
