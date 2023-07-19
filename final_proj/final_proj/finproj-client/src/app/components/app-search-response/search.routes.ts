import {Routes} from "@angular/router";
import {AppSearchComponent} from "../app-search/app-search.component";
import {AppSearchResponseComponent} from "./app-search-response.component";

export const SEARCH_ROUTES: Routes = [
  {
    path: '',
    component : AppSearchResponseComponent
  }
]
