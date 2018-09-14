import { Observable } from 'rxjs';
import { Category } from './../product/product.component';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  headers = new HttpHeaders().set('Content-Type', 'application/json');
  options = { headers: this.headers };

  constructor(private http:HttpClient) { }

  findCategory(categoryName):Observable<Category[]>{
    let categoryJSON = { categoryName: categoryName};
    return this.http.post<Category[]>('http://localhost:8080/searchcategory', JSON.stringify(categoryJSON), this.options);
  }
}
