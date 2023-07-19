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
  sizes: number[] = [3, 5, 10, 50];
  sort : string[] = ['asc', 'desc']

  requestForm = this._fb.group({
    page: new FormControl(0),
    size: new FormControl(10),
    sort: new FormControl('asc'),
  })

  constructor(private _imageService: ImageService, private _fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.data$ = this._imageService.loadImages(this.requestForm.value.page!, this.requestForm.value.size!, this.requestForm.value.sort!, 'id');
    this.requestForm.valueChanges.subscribe(valueChanges => {
      if (valueChanges.size && valueChanges.page && valueChanges.sort) {
        this.data$ = this._imageService.loadImages(valueChanges.page, valueChanges.size, valueChanges.sort, 'id');
      }
    })
  }

  showPage(page: number): void {
    this.data$ = this._imageService.loadImages(page, this.requestForm.value.size!, this.requestForm.value.sort!);
  }
}
