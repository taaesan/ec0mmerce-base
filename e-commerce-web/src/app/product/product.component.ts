import { CategoryService } from './../service/category.service';
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
  categories:Category[];
  selectedCategory = 0;
  priceRange = 50000;

  constructor(private productService: ProductService, private categoryService: CategoryService) {


  }

  displayedColumns: string[] = ['position', 'name', 'price', 'weight', 'symbol'];
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

    this.categoryService.findCategory(null)
      .subscribe(response => {
        console.log(response);
        this.categories = response;

      });
  }



  getNext(event: PageEvent) {
    if (this.productName.length == 0) {
      this.loadData(event.pageIndex);
    } else {
      this.searchProduct(event.pageIndex);
    }
  }

  searchProduct(pageIndex: number) {
    console.log("search : " + this.productName);

    //if (this.productName.length > 0) {

      this.productService.findProduct(this.productName, this.selectedCategory, this.priceRange, pageIndex)
        .subscribe(response => {
          console.log(response);
          this.dataSource.data = response.content;
          this.resultsLength = response.totalElements;
          this.pageIndex = response.pageable.pageNumber;

        });
    //}
  }

  delete($event) {

    if (confirm('Are you sure to delete this?')) {

      let target = $event.target || $event.srcElement || $event.currentTarget;
      let idAttr = target.attributes.id;
      let id = idAttr.nodeValue;
      console.log(id);

      this.productService.delete(id).subscribe(res => {
        console.log('Deleted Product : ' + id);
        this.loadData(0);
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
