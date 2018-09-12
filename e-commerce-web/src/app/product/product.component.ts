import { Observable } from 'rxjs';
import { Http } from '@angular/http';

import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatTableDataSource, PageEvent} from '@angular/material';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  resultsLength = 0;
  pageIndex = 0;
  offset = 0;
  constructor(private _http:Http){
       

  }

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = new MatTableDataSource<ProductElement>();
  data:Observable<Response>;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {

    this.loadData(0);


  }

  loadData(pageIndex:number){

    this._http.get('http://localhost:8080/productslist?page='+pageIndex+'&size=20')
    .subscribe(response =>{
      console.log(response.json());
      //this.dataSource = new MatTableDataSource<ProductElement>(response.json().content);
      this.dataSource.data = response.json().content;
      this.resultsLength = response.json().totalElements;
      this.pageIndex = response.json().pageable.pageNumber;
      
    });
  }

  getNext(event: PageEvent) {
    this.loadData(event.pageIndex);
  }

}

export interface ProductElement{
  id: number;
  productName: string;
  createdDate: Date;
  category: Category;
}

export interface Category{
  categoryName: string;
  parent:Category;
}
