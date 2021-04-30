import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { JobCardRoutingModule } from './job-card-routing.module';
import { AddEditComponent } from './add-edit/add-edit.component';
import { ListComponent } from './list/list.component';
import { imports } from '../_helper/moduleImports';


@NgModule({
  declarations: [
    AddEditComponent,
    ListComponent
  ],
  imports: [
    CommonModule,
    JobCardRoutingModule,
    ...imports
  ]
})
export class JobCardModule { }
