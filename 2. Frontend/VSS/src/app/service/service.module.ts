import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServiceRoutingModule } from './service-routing.module';
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
    ServiceRoutingModule,
    ...imports
  ]
})
export class ServiceModule { }
