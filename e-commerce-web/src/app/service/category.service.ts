
import { environment } from './../../environments/environment';
import { Observable } from 'rxjs';
import { Category } from './../product/product.component';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private API_URL = environment.API_URL;
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  options = { headers: this.headers };

  constructor(private http:HttpClient) { }

  findCategory(categoryName):Observable<Category[]>{
    let categoryJSON = { categoryName: categoryName};
    return this.http.post<Category[]>(this.API_URL+'/searchcategory', JSON.stringify(categoryJSON), this.options);
  }

  findCategoryById(id):Observable<Category>{
    let categoryJSON = { id: id};
    return this.http.post<Category>(this.API_URL+'/searchcategoryid', JSON.stringify(categoryJSON), this.options);
  }

  save(categoryId, categoryName, parentId):Observable<Category>{
    console.log("save...");
    let categoryJSON = { categoryId:categoryId, categoryName:categoryName, parentId:parentId};
    return this.http.post<Category>(this.API_URL+'/savecategory', JSON.stringify(categoryJSON), this.options);
  }

  delete(categoryId):Observable<Category>{
    console.log("delete...");
    let categoryJSON = { categoryId:categoryId};
    return this.http.post<Category>(this.API_URL+'/delete.category', JSON.stringify(categoryJSON), this.options);
  }
  
}
