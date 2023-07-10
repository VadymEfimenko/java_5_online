export interface ProductPdpModel {
  id: number;
  name: string;

  description: string;

  images: string[];

  price: number;

  sizeList: number[];

  cornicioneTypeList: string[];

  toppingList: string[];

  cheeseList: string[];

  crustTypeList: string[];
}
