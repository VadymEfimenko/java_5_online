import {Component, OnInit} from '@angular/core';
import {ProductVariantService} from "../../../services/product-variant.service";
import {FormBuilder, FormControl, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgForOf} from "@angular/common";
import {ProductVariantModel} from "../../../models/product-variant.model";
import {Router} from "@angular/router";
import {ProductService} from "../../../services/product-service";
import {ProductModel} from "../../../models/product.model";
import {ImageService} from "../../../services/image-service";
import {ImageModel} from "../../../models/image.model";

@Component({
  selector: 'app-image-add',
  templateUrl: './image-add.component.html',
  styleUrls: ['./image-add.component.scss'],
  imports: [
    ReactiveFormsModule,
    NgForOf
  ],
  standalone: true
})
export class ImageAddComponent implements OnInit {

  formProduct = this._fb.group({
    imageUrl: new FormControl('', [Validators.required]),
    mainImage: new FormControl(true, [Validators.required])
  })

  mainImages: boolean[] = [
    true,
    false
  ];

  constructor(
    private _imageService: ImageService,
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

      let imageUrl = this.formProduct.value.imageUrl as string;
      let mainImage = this.formProduct.value.mainImage as boolean;

      let image : ImageModel = {
        imageUrl,
        mainImage
      };
      this._imageService.createImage(image)
        .subscribe(
          (res) => {
            if (res) {
              this._router.navigateByUrl('image')
            }
          },
          (error) => {
            console.log('error', error)
          }
        );
    }
  }
}
