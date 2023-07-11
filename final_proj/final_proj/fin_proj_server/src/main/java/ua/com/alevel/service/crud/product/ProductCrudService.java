package ua.com.alevel.service.crud.product;

import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.service.crud.CrudService;

import java.util.Collection;
import java.util.List;

public interface ProductCrudService extends CrudService<Product> {

    Collection<Product> findAll();

    List<Product> findProductsByNameContainsIgnoreCase(String query);
}
