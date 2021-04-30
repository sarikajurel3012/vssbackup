import { Component, NgModule, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { HttpServiceService } from 'src/app/http-service/http-service.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  constructor(private httpServiceService: HttpServiceService) {}

  myVehicles = [];

  RegNo = new FormControl('');
  VehicleModel = new FormControl('');
  EngineNo = new FormControl('');
  ChasisNo = new FormControl('');

  isNewCustomer = new FormControl(true);
  CustId = new FormControl('');
  CustomerName = new FormControl('');
  CustomerContact = new FormControl('');
  CustomerAddress = new FormControl('');

  InsuranceNo = new FormControl('');
  InsuranceDate = new FormControl('');
  InsuranceDuration = new FormControl('');
  InsuranceAmount = new FormControl('');
  InsuranceNominee = new FormControl('');

  async showVehicles() {
    const response = await this.httpServiceService
      .getCustomer(this.CustId.value)
      .toPromise();
    this.myVehicles = response['vehicles'];
  }

  onSubmit() {
    if (this.isNewCustomer['value']) {
      this.saveCustomer();
    } else {
      this.saveVehicle(this.CustId.value);
    }
  }

  saveCustomer() {
    let custId = undefined;
    const response = {
      name: this.CustomerName.value,
      contact: this.CustomerContact.value,
      address: this.CustomerAddress.value,
    };
    this.httpServiceService.addCustomer(response).subscribe(
      (pass) => {
        console.log(pass);
        custId = pass['id'];

        this.saveVehicle(custId);
      },

      (fail) => {
        console.warn(fail);
      }
    );
  }

  saveVehicle(custId) {
    const response = {
      regNo: this.RegNo.value,
      model: this.VehicleModel.value,
      engineNo: this.EngineNo.value,
      chasisNo: this.ChasisNo.value,
      customer: { id: custId },
    };

    this.httpServiceService.addVehicle(response).subscribe(
      (pass) => {
        console.log(pass);
        this.saveInsurance(pass['id']);
      },
      (fail) => {
        console.warn(fail);
      }
    );
  }

  saveInsurance(vehicleId: number) {
    const response = {
      date: this.InsuranceDate.value,
      duration: this.InsuranceDuration.value,
      amount: this.InsuranceAmount.value,
      nominee: this.InsuranceNominee.value,
      vehicle: {
        id: vehicleId,
      },
    };

    this.httpServiceService.addInsurance(response).subscribe(
      (pass) => {
        console.log(pass);
      },
      (fail) => {
        console.warn(fail);
      }
    );
  }

  ngOnInit(): void {}
}
