import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  user = new User();
  // msg = '';
  constructor(private _service: RegistrationService, private _router: Router) { }

  ngOnInit(){
  }

  registerUser(){
    this._service.registrationUsernFromRemote(this.user).subscribe(
      data =>{ console.log('response recieved');
      // this.msg="Registation Successfully";
      this._router.navigate(['login'])
    },
      error => {console.log ("Exception occured");
      // this.msg=error.error;
    }
    )
  }

  gotologin(){
    this._router.navigate(['login'])
  }

}
