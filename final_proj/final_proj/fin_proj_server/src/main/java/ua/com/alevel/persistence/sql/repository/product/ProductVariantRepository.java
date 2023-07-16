package ua.com.alevel.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;
import ua.com.alevel.persistence.sql.type.CornicioneType;
import ua.com.alevel.persistence.sql.type.CrustType;
import ua.com.alevel.persistence.sql.type.ToppingAndCheeseType;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ProductVariantRepository extends BaseEntityRepository<ProductVariant> {

    Collection<ProductVariant> findByProduct(Product product);

    Optional<ProductVariant> findByProductAndSizeAndCornicioneTypeAndToppingAndCheeseAndCrustType(
            Product product, Integer size, CornicioneType cornicioneType, ToppingAndCheeseType topping, ToppingAndCheeseType cheese, CrustType crustType
    );
}
