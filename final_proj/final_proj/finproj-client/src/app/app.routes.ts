import {Routes} from "@angular/router";
import {ProductAttachComponent} from "./pages/product/product-attach/product-attach.component";


export const APP_ROUTES: Routes = [
  {
    path: '',
    redirectTo: 'plp',
    pathMatch: 'full'
  },
  {
    path: 'plp',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/plp/plp.routes').then(m => m.PLP_ROUTES)
  },
  {
    path: 'pdp',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/pdp/pdp.routes').then(m => m.PDP_ROUTES)
  },
  {
    path: 'register',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/register/register.router').then(m => m.REGISTER_ROUTES)
  },
  {
    path: 'login',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/login/login.router').then(m => m.LOGIN_ROUTES)
  },
  {
    path: 'cart',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/cart/cart.router').then(m => m.CART_ROUTES)
  },
  {
    path: 'product-variant',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/product-variant/product-variant.routes').then(m => m.PRODUCT_VARIANT_ROUTES)
  },
  {
    path: 'product',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/product/product.routes').then(m => m.PRODUCT_ROUTES)
  },
  {
    path: 'image',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/image/image.routes').then(m => m.IMAGE_ROUTES)
  },
  {
    path: 'attach',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/product/product-attach/product-attach.routes').then(m => m.PRODUCT_ATTACH_ROUTES)
  },
  {
    path: 'search',
    pathMatch: 'prefix',
    loadChildren:() => import('./components/app-search-response/search.routes').then(m => m.SEARCH_ROUTES)
  }
];
