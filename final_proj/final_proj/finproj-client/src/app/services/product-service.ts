import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {DataTableModel} from "../models/data-table.model";
import {DataContainer} from "../models/data.container";
import {appSettings} from "../app.const";
import {ProductModel} from "../models/product.model";
import {AttachModel} from "../models/attach.model";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _http: HttpClient, private _router : Router) {
  }

  loadProducts(page: number, size: number, sort: string, order: string)
    : Observable<DataTableModel<ProductModel>> {
    const params: HttpParams = new HttpParams()
      .set('page', page)
      .set('size', size!)
      .set('sort', sort)
      .set('order', order);
    return this._http.get(appSettings.apiPrivateAdmin + '/products', {params})
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

  createProduct(product: ProductModel): Observable<boolean> {
    return this._http.post(appSettings.apiPrivateAdmin + '/products', product)
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

  attachProduct(attach: AttachModel, id: string): Observable<boolean> {
    return this._http.put(appSettings.apiPrivateAdmin + '/products/' + id + '/process/attach', attach)
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }


  deleteProduct(id: number): Observable<boolean> {
    console.log('service' + id);
    return this._http.delete(appSettings.apiPrivateAdmin + '/products/' + id)
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })

      )
  }
}
