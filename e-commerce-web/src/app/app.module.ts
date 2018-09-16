import { CategoryService } from './service/category.service';
import { ProductService } from './service/product.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { MatTableModule, MatPaginatorModule, MatInputModule, MatFormFieldModule, MatSelectModule } from '@angular/material'

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProductComponent } from './product/product.component';
import { CategoryComponent } from './category/category.component';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { CategoryEditComponent } from './category-edit/category-edit.component';
import { CategoryAddComponent } from './category-add/category-add.component';
import { ProductAddComponent } from './product-add/product-add.component';
import { ProductEditComponent } from './product-edit/product-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    ProductComponent,
    CategoryComponent,
    CategoryEditComponent,
    CategoryAddComponent,
    ProductAddComponent,
    ProductEditComponent

  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {
        path: '',
        redirectTo: '/products',
        pathMatch: 'full'
      },
      
      { path: 'products/:id', component: ProductEditComponent },
      { path: 'products', component: ProductComponent },
      { path: 'products.add', component: ProductAddComponent },

      { path: 'categories/:id', component: CategoryEditComponent },
      { path: 'categories', component: CategoryComponent },
      { path: 'categories.add', component: CategoryAddComponent }
    ]),
    BrowserAnimationsModule,
    
    MatTableModule,
    MatPaginatorModule,
    MatInputModule,
    MatFormFieldModule, 
    MatSelectModule,
    
    HttpClientModule,
    HttpModule,
    FormsModule,

    RouterModule
  ],
  providers: [
    ProductService,
    CategoryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
