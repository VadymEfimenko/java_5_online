import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Observable} from "rxjs";
import {ProductPlpModel} from "../../models/product-plp.model";
import {PlpService} from "../../services/plp.service";
import {Router} from "@angular/router";
import {ProductSearchService} from "../../services/product-search.service";
import {query} from "@angular/animations";
import {AppSearchComponent} from "../app-search/app-search.component";

@Component({
  selector: 'app-app-search-response',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app-search-response.component.html',
  styleUrls: ['./app-search-response.component.scss']
})
export class AppSearchResponseComponent implements OnInit{

  data$ : Observable<ProductPlpModel[]> | undefined ;

  constructor(private _searchService: ProductSearchService, private _router: Router, private _appSearch: AppSearchComponent) { }


  ngOnInit(): void {
    this._appSearch.queryForm.valueChanges.subscribe(valueChanges => {
      if (valueChanges.query) {
        this.data$ = this._searchService.loadSearchProducts(valueChanges.query);
      }
    })
  }

  redirectToPdp(productId: number): void {
    this._router.navigateByUrl('/pdp/' + productId);
  }
}
