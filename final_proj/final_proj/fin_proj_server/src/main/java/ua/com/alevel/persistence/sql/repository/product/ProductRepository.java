package ua.com.alevel.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseEntityRepository<Product> {

    List<Product> findProductsByNameContainsIgnoreCase(String query);

}
