import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ScratchComponent } from './scratch/scratch.component';
import {HttpClientModule} from "@angular/common/http";
import { PurchasesComponent } from './purchases/purchases.component';


@NgModule({
  declarations: [
    AppComponent,
    ScratchComponent,
    PurchasesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
