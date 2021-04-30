import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../_models/customer';
import { environment } from '../../environments/environment';



@Injectable({
  providedIn: 'root'
})
export class AbstractDataService<T> {
  constructor(private model: string, private httpClient: HttpClient) { }

  baseUrl = environment.baseUrl + '/' + this.model;

  getAll() {
    return this.httpClient.get<T[]>(this.baseUrl);
  }

  get(id: number) {
    return this.httpClient.get<T>(this.baseUrl + `${id}`);
  }

  post(item: T) {
    return this.httpClient.post<T>(this.baseUrl, item);
  }

  put(item: T) {
    return this.httpClient.post<T>(this.baseUrl, item);
  }
}
