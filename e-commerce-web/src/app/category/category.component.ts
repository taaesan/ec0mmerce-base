import { MatTableDataSource } from '@angular/material';
import { Category } from './../product/product.component';
import { CategoryService } from './../service/category.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {


  displayedColumns: string[] = ['no', 'name', 'parent'];
  dataSource = new MatTableDataSource<Category>();

  constructor(private service: CategoryService) { }

  ngOnInit() {
    this.service.findCategory(null)
      .subscribe(response => {
        console.log(response);
        this.dataSource.data = response;

      });
  }



}
