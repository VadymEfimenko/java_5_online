import {Routes} from "@angular/router";
import {ProductItemsComponent} from "./product-items/product-items.component";
import {ProductAddComponent} from "./product-add/product-add.component";
import {ProductAttachComponent} from "./product-attach/product-attach.component";

export const PRODUCT_ROUTES: Routes = [
  {
    path: '',
    component: ProductItemsComponent
  },
  {
    path: 'new',
    component: ProductAddComponent
  },


];
