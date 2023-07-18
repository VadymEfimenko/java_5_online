import {Component, OnInit} from '@angular/core';
import {ProductVariantService} from "../../../services/product-variant.service";
import {FormBuilder, FormControl, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgForOf} from "@angular/common";
import {ProductVariantModel} from "../../../models/product-variant.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-variant-add',
  templateUrl: './product-variant-add.component.html',
  styleUrls: ['./product-variant-add.component.scss'],
  imports: [
    ReactiveFormsModule,
    NgForOf
  ],
  standalone: true
})
export class ProductVariantAddComponent implements OnInit {

  sizeTypes: number[] = [
    40, 50, 60
  ];

  cornicioneTypes: string[] = [
    'CHEESE_CORNICIONE',
    'HUNTERS_SAUSAGE_CORNICIONE',
    'VIENNA_SAUSAGES_CORNICIONE'
  ];

  toppingAndCheeseTypes: string[] = [
    'STANDARD',
    'DOUBLE'
  ];
  crustType: string[] = [
    'SPICY',
    'CREAMY',
    'CAESAR',
  ];

  formProduct = this._fb.group({
    size: new FormControl(40, [Validators.required]),
    cornicioneType: new FormControl('', [Validators.required]),
    topping: new FormControl('', [Validators.required]),
    cheese: new FormControl('', [Validators.required]),
    crustType: new FormControl('', [Validators.required]),
    price : new FormControl(0, [Validators.required])
  })

  constructor(
    private _productVariantService: ProductVariantService,
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

      let size = this.formProduct.value.size as number;
      let cornicioneType = this.formProduct.value.cornicioneType as string;
      let topping = this.formProduct.value.topping as string;
      let cheese = this.formProduct.value.cheese as string;
      let crustType = this.formProduct.value.crustType as string;
      let price = this.formProduct.value.price as number;

      let product: ProductVariantModel = {
        size,
        cornicioneType,
        topping,
        cheese,
        crustType,
        price
      };
    console.log(price)
      this._productVariantService.createProduct(product)
        .subscribe(
          (res) => {
            if (res) {
              this._router.navigateByUrl('product-variant')
            }
          },
          (error) => {
            console.log('error', error)
          }
        );
    }
  }
}
