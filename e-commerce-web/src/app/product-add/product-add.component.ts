import { ProductService } from './../service/product.service';
import { Router } from '@angular/router';
import { Category } from './../product/product.component';
import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../service/category.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  categories: Category[];

  selectedCategory = 0;
  productNameChanged = "";
  priceChanged = 0;
  

  constructor(private router: Router, private categoryService: CategoryService, private productService: ProductService) { }

  ngOnInit() {
    this.categoryService.findCategory(null)
      .subscribe(response => {
        this.categories = response;
      });
  }

  save(){

    console.log(this.productNameChanged);

    if(this.productNameChanged.length > 0 ){
      this.productService.save(null, this.productNameChanged, this.priceChanged, this.selectedCategory).subscribe(res=>{
        console.log('Product Saved...');
        this.router.navigate(['/products']);
      });
    }
  }

}
