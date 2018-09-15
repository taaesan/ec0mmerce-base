import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductResponse, ProductElement } from './../product/product.component';
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

  findProduct(productName, categoryId, priceMax, pageIndex: number):Observable<ProductResponse>{
    let product = { 
      productName: productName,
      categoryId: categoryId,
      priceMax: priceMax, 
      page: pageIndex
    };
    return this.http.post<ProductResponse>('http://localhost:8080/searchproduct', JSON.stringify(product), this.options);
  }

  findProductById(id):Observable<ProductElement>{
    let categoryJSON = { id: id};
    return this.http.post<ProductElement>('http://localhost:8080/searchproduct.id', JSON.stringify(categoryJSON), this.options);
  }


  save(productId, productName, price, categoryId):Observable<ProductElement>{
    console.log("save...");
    let categoryJSON = { productId: productId, productName:productName, price:price, categoryId:categoryId};
    return this.http.post<ProductElement>('http://localhost:8080/saveproduct', JSON.stringify(categoryJSON), this.options);
  }

  delete(productId):Observable<ProductElement>{
    console.log("delete...");
    let categoryJSON = { productId:productId};
    return this.http.post<ProductElement>('http://localhost:8080/delete.product', JSON.stringify(categoryJSON), this.options);
  }
}
