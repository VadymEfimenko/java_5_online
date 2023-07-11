import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, map, Observable} from "rxjs";

import {DataContainer} from "../models/data.container";
import {FormControl, FormGroup} from "@angular/forms";
import {ProductPlpModel} from "../models/product-plp.model";


@Injectable({
  providedIn: 'root'
})
export class ProductSearchService {


  constructor(private _http: HttpClient) {
  }


}
