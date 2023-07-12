import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductSearchService} from "../../services/product-search.service";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {BehaviorSubject, map, Observable, take} from "rxjs";
import {ProductPlpModel} from "../../models/product-plp.model";
import {DataContainer} from "../../models/data.container";
import {HttpClient} from "@angular/common/http";
import {PlpComponent} from "../../pages/plp/plp.component";
import {PlpService} from "../../services/plp.service";

@Component({
  selector: 'app-search',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './app-search.component.html',
  styleUrls: ['./app-search.component.scss']
})
export class AppSearchComponent {

  queryForm: FormGroup = new FormGroup({
    query: new FormControl()
  });

  constructor(private _http: HttpClient, private _searchService: ProductSearchService) {
  }

  searchProduct(): void {
    this._searchService.loadSearchProducts(this.queryForm.value.query);
  }
}
