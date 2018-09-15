import { Category } from './../product/product.component';
import { CategoryService } from './../service/category.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {

  category: Category;
  categories: Category[];

  selectedCategory = 0;
  categoryNameChanged;

  constructor(private router:Router, private activedRoute: ActivatedRoute, private categoryService: CategoryService) { }

  ngOnInit() {

    this.activedRoute.paramMap.subscribe(params => {

      let id = +params.get('id');

      this.categoryService.findCategoryById(id).subscribe(res => {
        //console.log(res.categoryName);
        this.category = res;
        this.selectedCategory = res.parent.id;
        console.log(this.category);
      });

      //call service
      this.categoryService.findCategory(null)
        .subscribe(response => {
          //console.log(response);
          this.categories = response;

        });

    });

  

  }

  save(){
    console.log(this.categoryNameChanged);
    console.log(this.selectedCategory);

    this.router.navigate(['/categories']);
  }

}
