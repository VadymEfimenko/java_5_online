import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {DataTableModel} from "../models/data-table.model";
import {DataContainer} from "../models/data.container";
import {appSettings} from "../app.const";
import {ImageModel} from "../models/image.model";

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private _http: HttpClient) {
  }

  loadImages(page: number, size: number, sort: string, order: string = 'id')
    : Observable<DataTableModel<ImageModel>> {
    const params: HttpParams = new HttpParams()
      .set('page', page)
      .set('size', size)
      .set('sort', sort)
      .set('order', order);
    return this._http.get(appSettings.apiPrivateAdmin + '/product-images', {params})
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

  createImage(image: ImageModel): Observable<boolean> {
    return this._http.post(appSettings.apiPrivateAdmin + '/product-images', image)
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
