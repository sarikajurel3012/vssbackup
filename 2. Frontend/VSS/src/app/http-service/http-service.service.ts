import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class HttpServiceService {
  baseUrl = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) {}

  addCustomer(data) {
    return this.httpClient.post(`${this.baseUrl}/customer`, data);
  }

  addVehicle(data) {
    return this.httpClient.post(`${this.baseUrl}/vehicle`, data);
  }

  addInsurance(data) {
    return this.httpClient.post(`${this.baseUrl}/insurance`, data);
  }

  getCustomer(customerId: number) {
    return this.httpClient.get(`${this.baseUrl}/customer/${customerId}`);
  }

  addJobcard(data) {
    return this.httpClient.post(`${this.baseUrl}/jobcard`, data);
  }
}
