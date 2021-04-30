import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

import { CustomerRoutingModule } from './customer-routing.module';
import { AddEditComponent } from './add-edit/add-edit.component';
import { ListComponent } from './list/list.component';
import { imports } from '../_helper/moduleImports';


@NgModule({
  declarations: [
    AddEditComponent,
    ListComponent,
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    ...imports
  ]
})
export class CustomerModule { }
