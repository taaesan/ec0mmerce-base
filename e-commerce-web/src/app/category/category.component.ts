import { Router } from '@angular/router';
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

  constructor(private router: Router, private categoryService: CategoryService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.categoryService.findCategory(null)
      .subscribe(response => {
        console.log(response);
        this.dataSource.data = response;
      });
  }

  delete($event) {

    if (confirm('Are you sure to delete this?')) {

      let target = $event.target || $event.srcElement || $event.currentTarget;
      let idAttr = target.attributes.id;
      let id = idAttr.nodeValue;
      console.log(id);

      this.categoryService.delete(id).subscribe(res => {
        console.log('Deleted Category : ' + id);
        this.loadData();
        this.router.navigate(['/categories']);
      })

    }
  }



}
