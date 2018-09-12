import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import {MatTableModule, MatPaginatorModule} from '@angular/material'

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProductComponent } from './product/product.component';
import { CategoryComponent } from './category/category.component';
import {HttpModule} from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    ProductComponent,
    CategoryComponent
    
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: 'products', component : ProductComponent},
      { path: 'categories', component : CategoryComponent}
    ]),
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    HttpModule
  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
