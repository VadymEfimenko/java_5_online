import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {BehaviorSubject, map, Observable} from "rxjs";

import {DataContainer} from "../models/data.container";
import {FormControl, FormGroup} from "@angular/forms";
import {ProductPlpModel} from "../models/product-plp.model";
import {appSettings} from "../app.const";


@Injectable({
  providedIn: 'root'
})
export class ProductSearchService {


  constructor(private _http: HttpClient) {
  }

  loadSearchProducts(query : string): Observable<ProductPlpModel[]> {
    console.log(query);
    const params : HttpParams = new HttpParams()
      .set('query', query);
    return this._http.get(appSettings.apiOpen + '/products/plp/search', {params})
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
