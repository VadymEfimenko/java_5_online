import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PdpService} from "../../services/pdp.service";
import {ProductPdpModel} from "../../models/product-pdp.model";
import {CommonModule} from "@angular/common";
import {BehaviorSubject, Observable, take, tap} from "rxjs";
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


  setSize(size: number): void {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.size = size;
          this._productResultSub$.next({ ...ps });
          // this._form.controls.os.setValue(os);

      // its commented in egor   // this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }


  setCornicione(cornicione: string) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.cornicioneType = cornicione;
          this._productResultSub$.next({ ...ps });
          // this._form.controls.os.setValue(os);

          // its commented in egor   // this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setTopping(topping: string) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.topping = topping;
          this._productResultSub$.next({ ...ps });
          // this._form.controls.os.setValue(os);

          // its commented in egor   // this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setCheese(cheese: string) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.cheese = cheese;
          this._productResultSub$.next({ ...ps });
          // this._form.controls.os.setValue(os);

          // its commented in egor   // this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setCrust(crust: string) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.crustType = crust;
          this._productResultSub$.next({ ...ps });
          // this._form.controls.os.setValue(os);

          // its commented in egor   // this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }
}
