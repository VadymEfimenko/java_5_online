import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {DataContainer} from "../models/data.container";

@Injectable({
  providedIn: 'root'
})
export class PlpService {

  constructor(private _http: HttpClient) {

  }

  loadProducts(): Observable<Object> {
    return this._http.get('http://localhost:8080/products/plp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

  // searchProduct(query: string): Observable<any> {
  //   return this._http.get('http://localhost:8080/products/search?query=' + query)
  //     .pipe(
  //       map(res => {
  //         const data: DataContainer = res as DataContainer;
  //         return data.data;
  //       })
  //     );
  // }
}
