import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {DataTableModel} from "../models/data-table.model";
import {DataContainer} from "../models/data.container";
import {appSettings} from "../app.const";
import {ProductModel} from "../models/product.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _http: HttpClient) {
  }

  loadProducts(page: number = 0, size: number = 10, sort: string = 'asc', order: string = 'id')
    : Observable<DataTableModel<ProductModel>> {
    const params: HttpParams = new HttpParams()
      .set('page', page)
      .set('size', size)
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
}
