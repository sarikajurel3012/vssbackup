import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractDataService } from './AbstractDataService';
import { JobCard } from '../_models/JobCard';


@Injectable({
  providedIn: 'root'
})
export class JobCardDataService extends AbstractDataService<JobCard> {
  constructor(private http: HttpClient) {
    super('jobcard', http);
  }
}
