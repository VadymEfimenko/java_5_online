import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PdpService} from "../../services/pdp.service";
import {ProductPdpModel} from "../../models/product-pdp.model";
import {CommonModule} from "@angular/common";
import {BehaviorSubject, Observable, switchMap, take, tap} from "rxjs";
import {defaultProductResultModel, ProductResultModel} from "../../models/product-result.model";
import {CartService} from "../../services/cart.service";
import {FormBuilder, FormControl, Validators} from "@angular/forms";

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

  _form = this._fb.group({
    size: new FormControl(0, [Validators.required]),
    cornicioneType: new FormControl('', [Validators.required]),
    topping: new FormControl('', [Validators.required]),
    cheese: new FormControl('', [Validators.required]),
    crustType: new FormControl('', [Validators.required]),

  })

  constructor(private _fb: FormBuilder, private _router: Router, private _pdpService: PdpService, private _cartService: CartService) {
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
          const ps: ProductResultModel = {...res};
          ps.size = size;
          this._productResultSub$.next({...ps});
          this._form.controls.size.setValue(size);

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
          const ps: ProductResultModel = {...res};
          ps.cornicioneType = cornicione;
          this._productResultSub$.next({...ps});
          this._form.controls.cornicioneType.setValue(cornicione);

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
          const ps: ProductResultModel = {...res};
          ps.topping = topping;
          this._productResultSub$.next({...ps});
          this._form.controls.topping.setValue(topping);

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
          const ps: ProductResultModel = {...res};
          ps.cheese = cheese;
          this._productResultSub$.next({...ps});
          this._form.controls.cheese.setValue(cheese);

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
          const ps: ProductResultModel = {...res};
          ps.crustType = crust;
          this._productResultSub$.next({...ps});
          this._form.controls.crustType.setValue(crust);
          //
          // its commented in egor   // this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  addToCart(): void {
    this.productResult$
      .pipe(
        switchMap(res => this._pdpService.loadProductIdByVariants(this.product?.id as number, res)),
        switchMap(res => this._cartService.addToCart(res, 1)),
      )
      .subscribe((res) => {
        this._router.navigateByUrl('/cart')
      }, (error) => {
        console.log('error', error);
        this._router.navigateByUrl('/login')
      });
  }
}
