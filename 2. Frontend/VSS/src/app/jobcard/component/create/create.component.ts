import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpServiceService } from 'src/app/http-service/http-service.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
})
export class CreateComponent implements OnInit {
  Issues = new FormControl('');
  Remarks = new FormControl('');
  Date = new FormControl();
  vehicleId = '';

  constructor(
    private httpServiceService: HttpServiceService,
    public activatedRoute: ActivatedRoute,
    private route: Router
  ) {}

  saveJobcard() {
    const response = {
      issues: this.Issues.value,
      remarks: this.Remarks.value,
      vehicle: {
        id: Number(this.vehicleId),
      },
    };

    this.httpServiceService.addJobcard(response).subscribe(
      (pass) => {
        console.log(pass);
      },
      (fail) => {
        console.log(fail);
      }
    );
  }

  async ngOnInit() {
    const urls = this.activatedRoute.url['value'];
    if (urls.length == 0) {
      this.route.navigate(['/']);
    }
    this.vehicleId = urls[0]['path'];
  }
}
