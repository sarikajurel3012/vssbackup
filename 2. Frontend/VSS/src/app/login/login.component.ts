import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user = new User(); 
  msg = '';
  constructor(private _service: RegistrationService, private _router : Router) { }

  ngOnInit(){
  }

  loginUser(){
    this._service.loginUsernFromRemote(this.user).subscribe(
      data =>{ console.log('response recieved');
      alert(JSON.stringify('Successfully login'));
      this._router.navigate(['hello-world'])
    },
      error => {console.log ("Exception occured");
      this.msg="Bad Credentials,Please enter valid EmailId and Password";
    }
    )
  }

  gotoregistration(){
    this._router.navigate(['registration'])
  }

}
