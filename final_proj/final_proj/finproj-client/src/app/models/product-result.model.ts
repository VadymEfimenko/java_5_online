export interface ProductResultModel {

  price?: number;

  size?: number;

  cornicioneType?: string;

  topping?: string;

  cheese?: string;

  crustType?: string;
}

export const defaultProductResultModel = {
  price: undefined,

  size: undefined,

  cornicioneType: undefined,

  topping: undefined,

  cheese: undefined,

  crustType: undefined
};
