package ua.com.alevel.facade.plp;

import ua.com.alevel.data.dto.product.ProductPLPDto;
import ua.com.alevel.persistence.sql.entity.product.Product;

import java.util.Collection;
import java.util.List;

public interface ProductPLPFacade {

    Collection<ProductPLPDto> findAll();

    List<ProductPLPDto> findProductsByNameContainsIgnoreCase(String query);
}
