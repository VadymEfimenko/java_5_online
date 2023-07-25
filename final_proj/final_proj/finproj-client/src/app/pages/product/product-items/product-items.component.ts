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

  data$: Observable<DataTableModel<ProductModel>> | undefined;
  sizes: number[] = [3, 5, 10, 50];
  sort : string[] = ['asc', 'desc']
  order : string[] = ['id', 'name']

  requestForm = this._fb.group({
    page: new FormControl(0),
    size: new FormControl(10),
    sort: new FormControl('asc'),
    order: new FormControl('id')
  })

  constructor(private _productService: ProductService, private _fb: FormBuilder, private _router: Router ) {
  }

  ngOnInit(): void {
    this.data$ = this._productService.loadProducts(this.requestForm.value.page!, this.requestForm.value.size!, this.requestForm.value.sort!, this.requestForm.value.order!);
    this.requestForm.valueChanges.subscribe(valueChanges => {
      if (valueChanges.size || valueChanges.page || valueChanges.sort || valueChanges.order) {
        this.data$ = this._productService.loadProducts(valueChanges.page!, valueChanges.size!, valueChanges.sort!, valueChanges.order!);
      }
    })
  }

  showPage(page: number): void {
    this.data$ = this._productService.loadProducts(page, this.requestForm.value.size!, this.requestForm.value.sort!, this.requestForm.value.order!);
  }

  redirectToAttach(id ?: number): void {
    this._router.navigateByUrl('/attach/' + id);
  }

  redirectToDelete(id?: number): void {
    this._productService.deleteProduct(id!).subscribe(
      (res)=>{
        if(res){
          this.showPage(this.requestForm.value.page!)
        }
      },(error)=>{
        console.log(error)
      }
    )
  }
}
