import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {Observable} from "rxjs";
import {FormBuilder, FormControl, ReactiveFormsModule} from "@angular/forms";

import {ProductVariantService} from "../../../services/product-variant.service";
import {DataTableModel} from "../../../models/data-table.model";
import {ProductVariantModel} from "../../../models/product-variant.model";

@Component({
  selector: 'app-product-variant-items',
  templateUrl: './product-variant-items.component.html',
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  styleUrls: ['./product-variant-items.component.scss'],
  standalone: true
})
export class ProductVariantItemsComponent implements OnInit {

  data$: Observable<DataTableModel<ProductVariantModel>> | undefined;
  sizes: number[] = [3, 5, 10, 50];
  sort : string[] = ['asc', 'desc']
  order : string[] = ['id', 'price', 'size']

  requestForm = this._fb.group({
    page: new FormControl(0),
    size: new FormControl(10),
    sort: new FormControl('asc'),
    order: new FormControl('id')
  })

  constructor(private _productVariantService: ProductVariantService, private _fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.data$ = this._productVariantService.loadProductVariants(this.requestForm.value.page!, this.requestForm.value.size!, this.requestForm.value.sort!, this.requestForm.value.order!);
    this.requestForm.valueChanges.subscribe(valueChanges => {
      if (valueChanges.size && valueChanges.page && valueChanges.sort && valueChanges.order) {
        this.data$ = this._productVariantService.loadProductVariants(valueChanges.page, valueChanges.size, valueChanges.sort, valueChanges.order);
      }
    })
  }

  showPage(page: number): void {
    this.data$ = this._productVariantService.loadProductVariants(page, this.requestForm.value.size!, this.requestForm.value.sort!, this.requestForm.value.order!);
  }
}
