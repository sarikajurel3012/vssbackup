import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractDataService } from './AbstractDataService';
import { Feedback } from '../_models/Feedback';


@Injectable({
  providedIn: 'root'
})
export class FeedbackDataService extends AbstractDataService<Feedback> {
  constructor(private http: HttpClient) {
    super('feedback', http);
  }
}
