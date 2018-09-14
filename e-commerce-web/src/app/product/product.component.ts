import { ProductService } from './../service/product.service';
import { RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";

import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource, PageEvent } from '@angular/material';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  resultsLength = 0;
  pageIndex = 0;
  offset = 0;

  productName = "";

  constructor(private productService: ProductService) {


  }

  displayedColumns: string[] = ['position', 'name', 'price','weight', 'symbol'];
  dataSource = new MatTableDataSource<ProductElement>();
  data: Observable<Response>;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {

    this.loadData(0);


  }

  loadData(pageIndex: number) {

    this.productService.findAllProduct(pageIndex)
      .subscribe(response => {
        console.log(response);
        this.dataSource.data = response.content;
        this.resultsLength = response.totalElements;
        this.pageIndex = response.pageable.pageNumber;

      });
  }

  getNext(event: PageEvent) {
    if (this.productName.length == 0) {
      this.loadData(event.pageIndex);
    }else{
      this.searchProduct(event.pageIndex);
    }
  }

  searchProduct(pageIndex: number) {
    console.log("search : " + this.productName);

    if (this.productName.length > 0) {

      this.productService.findProduct(this.productName, pageIndex)
      .subscribe(response => {
        console.log(response);
        this.dataSource.data = response.content;
        this.resultsLength = response.totalElements;
        this.pageIndex = response.pageable.pageNumber;

      });
    }
  }


}

export interface ProductResponse {
  content: ProductElement[];
  pageable: { pageNumber };
  totalElements: number;
}

export interface ProductElement {
  id: number;
  productName: string;
  createdDate: Date;
  category: Category;
  price: number;
}

export interface Category {
  id: number;
  categoryName: string;
  parent: Category;
}
