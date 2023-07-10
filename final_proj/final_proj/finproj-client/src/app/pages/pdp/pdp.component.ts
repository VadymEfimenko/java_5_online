import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PdpService} from "../../services/pdp.service";
import {ProductPdpModel} from "../../models/product-pdp.model";
import {CommonModule} from "@angular/common";
import {BehaviorSubject, Observable} from "rxjs";
import {defaultProductResultModel, ProductResultModel} from "../../models/product-result.model";

@Component({
  selector: 'app-pdp',
  standalone: true,
  templateUrl: './pdp.component.html',
  imports: [
    CommonModule
  ],
  styleUrls: ['./pdp.component.scss']
})
export class PdpComponent implements OnInit {

  private _productResultSub$: BehaviorSubject<ProductResultModel> = new BehaviorSubject<ProductResultModel>(defaultProductResultModel);

  public readonly productResult$: Observable<ProductResultModel> = this._productResultSub$.asObservable();
  product?: ProductPdpModel;

  constructor(private _router: Router, private _pdpService: PdpService) {
  }

  ngOnInit(): void {
    let url = this._router.routerState.snapshot.url;
    let productId = url.split('/')[2];
    this._pdpService
      .loadProductById(productId)
      .subscribe(value => {
        this.product = value as ProductPdpModel;
      });
    // this._form.statusChanges.subscribe(status => console.log('status', status))
  }

  // setSize(size : number): void{
  //
  // }

}
