package ua.com.alevel.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductVariantRepository extends BaseEntityRepository<ProductVariant> {

    Collection<ProductVariant> findByProduct(Product product);

    List<ProductVariant> findAllByCodeIn(List<String> codes);
}
