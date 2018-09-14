import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductResponse } from './../product/product.component';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  headers = new HttpHeaders().set('Content-Type', 'application/json');
  options = { headers: this.headers };

  constructor(private http:HttpClient) { }

  findAllProduct(pageIndex: number) : Observable<ProductResponse>{
    return this.http.get<ProductResponse>('http://localhost:8080/productslist?page=' + pageIndex + '&size=10');
  }

  findProduct(productName, pageIndex: number):Observable<ProductResponse>{
    let product = { productName: productName, page: pageIndex};
    return this.http.post<ProductResponse>('http://localhost:8080/searchproduct', JSON.stringify(product), this.options);
  }
}
