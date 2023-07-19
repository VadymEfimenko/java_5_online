package ua.com.alevel.service.crud.product.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.dto.product.ProductSearchDto;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.product.ProductVariantRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.product.ProductCrudService;
import ua.com.alevel.service.crud.product.ProductVariantCrudService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static ua.com.alevel.util.ExceptionUtil.ENTITY_NOT_FOUND;

@Service
@Transactional
public class ProductVariantCrudServiceImpl implements ProductVariantCrudService {

    private final ProductCrudService productCrudService;

    private final ProductVariantRepository productVariantRepository;
    private final CrudHelperService<ProductVariant, ProductVariantRepository> crudHelperService;

    public ProductVariantCrudServiceImpl(ProductCrudService productCrudService, ProductVariantRepository productVariantRepository, CrudHelperService<ProductVariant, ProductVariantRepository> crudHelperService) {
        this.productCrudService = productCrudService;
        this.productVariantRepository = productVariantRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(ProductVariant entity) {
        crudHelperService.create(entity, productVariantRepository);
    }

    @Override
    public void update(ProductVariant entity) {
        crudHelperService.update(entity, productVariantRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, productVariantRepository);
    }

    @Override
    public ProductVariant findById(Long id) {
        return crudHelperService.findById(id, productVariantRepository);
    }

    @Override
    public Page<ProductVariant> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, productVariantRepository);
    }

    @Override
    public Collection<ProductVariant> findByProduct(Product product) {
        return productVariantRepository.findByProduct(product);
    }

    @Override
    public Long findProductIdByVariants(ProductSearchDto dto) {
        Product product = productCrudService.findById(dto.getProductId());
        ProductVariant productVariant = productVariantRepository.findByProductAndSizeAndCornicioneTypeAndToppingAndCheeseAndCrustType(
                        product,
                        dto.getSize(),
                        dto.getCornicioneType(),
                        dto.getTopping(),
                        dto.getCheese(),
                        dto.getCrustType()
                )
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND));
        return productVariant.getId();
    }

    @Override
    public Set<ProductVariant> findAllByIdIn(Set<Long> ids) {
        return productVariantRepository.findAllByIdIn(ids);
    }
}
