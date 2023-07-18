import {Component, OnInit} from '@angular/core';
import {ProductVariantService} from "../../../services/product-variant.service";
import {FormBuilder, FormControl, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgForOf} from "@angular/common";
import {ProductVariantModel} from "../../../models/product-variant.model";
import {Router} from "@angular/router";
import {ProductService} from "../../../services/product-service";
import {ProductModel} from "../../../models/product.model";

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.scss'],
  imports: [
    ReactiveFormsModule,
    NgForOf
  ],
  standalone: true
})
export class ProductAddComponent implements OnInit {

  formProduct = this._fb.group({
    name: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required])
  })

  constructor(
    private _productService: ProductService,
    private _fb: FormBuilder,
    private _router: Router) {
  }

  ngOnInit(): void {
    this.formProduct.valueChanges.subscribe(values => {
      console.log('values', values)
    })
  }

  create(): void {

    let some = 'ffg,gssg,sgsg';
    let s = some.split(',');


    if (this.formProduct.valid) {
      console.log(this.formProduct.value)

      let name = this.formProduct.value.name as string;
      let description = this.formProduct.value.description as string;

      let product: ProductModel = {
        name,
        description
      };
      this._productService.createProduct(product)
        .subscribe(
          (res) => {
            if (res) {
              this._router.navigateByUrl('product')
            }
          },
          (error) => {
            console.log('error', error)
          }
        );
    }
  }
}
