import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {Observable} from "rxjs";
import {FormBuilder, FormControl, ReactiveFormsModule} from "@angular/forms";

import {DataTableModel} from "../../../models/data-table.model";
import {ProductModel} from "../../../models/product.model";
import {ProductService} from "../../../services/product-service";
import {ImageModel} from "../../../models/image.model";
import {ImageService} from "../../../services/image-service";

@Component({
  selector: 'app-image-items',
  templateUrl: './image-items.component.html',
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  standalone: true
})
export class ImageItemsComponent implements OnInit {

  data$: Observable<DataTableModel<ImageModel>> | undefined;
  sizes: number[] = [5, 10, 25, 50, 100];
  sizeForm = this._fb.group({
    size: new FormControl(10)
  })

  constructor(private _imageService: ImageService, private _fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.data$ = this._imageService.loadImages();
    this.sizeForm.valueChanges.subscribe(valueChanges => {
      if (valueChanges.size) {
        this.data$ = this._imageService.loadImages(0, valueChanges.size);
      }
    })
  }

  showPage(page: number): void {
    this.data$ = this._imageService.loadImages(page);
  }
}
