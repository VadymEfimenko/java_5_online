import {Routes} from "@angular/router";
import {ImageItemsComponent} from "./image-items/image-items.component";
import {ImageAddComponent} from "./image-add/image-add.component";

export const IMAGE_ROUTES: Routes = [
  {
    path: '',
    component: ImageItemsComponent
  },
  {
    path: 'new',
    component: ImageAddComponent
  }
];
