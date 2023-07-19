import {Routes} from "@angular/router";
import {ProductAttachComponent} from "./product-attach.component";

export const PRODUCT_ATTACH_ROUTES: Routes = [
  {
    path: ':id',
    component: ProductAttachComponent
  }
];
