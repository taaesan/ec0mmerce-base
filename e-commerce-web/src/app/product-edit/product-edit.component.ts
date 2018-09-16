import { Router, ActivatedRoute } from '@angular/router';
import { Category, ProductElement } from './../product/product.component';
import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../service/category.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  product: ProductElement;
  categories: Category[];

  selectedCategory = 0;
  productNameChanged = "";
  priceChanged = 0;

  constructor(private router: Router, private activedRoute: ActivatedRoute, private categoryService: CategoryService, private productService:ProductService) { }

  ngOnInit() {
    this.activedRoute.paramMap.subscribe(params => {

      let id = +params.get('id');

      this.productService.findProductById(id).subscribe(res => {
        console.log(res);
        this.product = res;
        this.selectedCategory = res.category.id;
        this.productNameChanged = res.productName;
        this.priceChanged = res.price;
        
      });

      //call service
      this.categoryService.findCategory(null)
        .subscribe(response => {
          console.log(response);
          this.categories = response;

        });

    });
  }

  save(){

    console.log(this.productNameChanged);

    if(this.productNameChanged.length > 0 ){
      this.productService.save(this.product.id, this.productNameChanged, this.priceChanged, this.selectedCategory).subscribe(res=>{
        console.log('Product Saved...');
        this.router.navigate(['/products']);
      });
    }
  }

}
