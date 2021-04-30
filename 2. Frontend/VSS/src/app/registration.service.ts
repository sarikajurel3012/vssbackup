import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http: HttpClient) { }

  public loginUsernFromRemote(user : User): Observable<any>{
     return this._http.post<any>("http://localhost:3306/vssSpringBoot1/vss/login", user);
  }

  public registrationUsernFromRemote(user : User): Observable<any>{
    return this._http.post<any>("http://localhost:3306/vssSpringBoot1/vss/registeruser", user);
 }
}
