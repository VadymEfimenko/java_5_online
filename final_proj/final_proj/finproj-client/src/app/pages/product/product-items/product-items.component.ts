import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {Observable} from "rxjs";
import {FormBuilder, FormControl, ReactiveFormsModule} from "@angular/forms";

import {DataTableModel} from "../../../models/data-table.model";
import {ProductModel} from "../../../models/product.model";
import {ProductService} from "../../../services/product-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-items',
  templateUrl: './product-items.component.html',
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  standalone: true
})
export class ProductItemsComponent implements OnInit {

  data$: Observable<DataTableModel<ProductModel>>  = this._productService.loadProducts();
  sizes: number[] = [5, 10, 25, 50, 100];
  sizeForm = this._fb.group({
    size: new FormControl(10)
  })

  constructor(private _productService: ProductService, private _fb: FormBuilder, private _router: Router) {
  }

  ngOnInit(): void {
    this.data$ = this._productService.loadProducts();
    this.sizeForm.valueChanges.subscribe(valueChanges => {
      if (valueChanges.size) {
        this.data$ = this._productService.loadProducts(0, valueChanges.size);
      }
    })
  }

  showPage(page: number): void {
    this.data$ = this._productService.loadProducts(page);
  }

  redirectToAttach(id ?: number): void {
    this._router.navigateByUrl('/attach/' + id);
  }

  redirectToDelete(id?: number): void {
    this._productService.deleteProduct(id!).subscribe();
  }
}
