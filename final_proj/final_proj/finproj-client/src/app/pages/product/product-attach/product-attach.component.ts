import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormBuilder, FormControl, ReactiveFormsModule, Validators} from "@angular/forms";
import {ProductService} from "../../../services/product-service";
import {Router} from "@angular/router";
import {AttachModel} from "../../../models/attach.model";

@Component({
  selector: 'app-product-attach',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './product-attach.component.html',
  styleUrls: ['./product-attach.component.scss']
})
export class ProductAttachComponent implements OnInit {

  constructor(
    private _productService: ProductService,
    private _fb: FormBuilder,
    private _router: Router) {
  }

  formProduct = this._fb.group({
    productVariantId: new FormControl('', [Validators.required]),
    productImages: new FormControl('', [Validators.required])
  })

  ngOnInit(): void {
    this.formProduct.valueChanges.subscribe(values => {
      console.log('values', values)
    })
  }

  attachProductId(): void {
    let url = this._router.routerState.snapshot.url;
    let productId = url.split('/')[2];
    console.log(url);
    if(this.formProduct.valid){
      console.log(this.formProduct.value)

      let productVariantIdStr = this.formProduct.value.productVariantId as string;
      let productImagesStr = this.formProduct.value.productImages as string;

      let productVariantIdsArr: string[] = productVariantIdStr.split(",");
      let productImagesIdsArr: string[] = productImagesStr.split(",");

      let prodVarNumArr : number[] = [];
      let prodImgNumArr : number[] = [];

      for (let i = 0; i < productVariantIdsArr.length; i++) {
        prodVarNumArr.push(Number(productVariantIdsArr[i]))
      }

      for (let i = 0; i < productImagesIdsArr.length; i++) {
        prodImgNumArr.push(Number(productImagesIdsArr[i]))
      }

      const attMod: AttachModel = {
        productImages: prodImgNumArr,
        productVariantId: prodVarNumArr,
      };


      this._productService.attachProduct(attMod, productId)
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
