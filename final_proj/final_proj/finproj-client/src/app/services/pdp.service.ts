import {Injectable} from "@angular/core";
import {map, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {DataContainer} from "../models/data.container";
import {appSettings} from "../app.const";

@Injectable({
  providedIn: 'root'
})
export class PdpService {

  constructor(private _http: HttpClient) { }

  loadProductById(productId: string): Observable<any> {
    return this._http.get(appSettings.apiOpen + '/products/' + productId + '/pdp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

}
