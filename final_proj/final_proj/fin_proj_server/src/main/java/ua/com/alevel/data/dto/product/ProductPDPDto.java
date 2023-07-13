package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.type.CornicioneType;
import ua.com.alevel.persistence.sql.type.CrustType;
import ua.com.alevel.persistence.sql.type.ToppingAndCheeseType;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductPDPDto {

    private Long id;
    private String name;
    private String description;
    private Set<String> images;
    private List<Integer> price;
    private List<Integer> sizeList;
    private List<String> cornicioneTypeList;
    private List<String> toppingList;
    private List<String> cheeseList;
    private List<String> crustTypeList;

    public ProductPDPDto(Product product, Collection<ProductVariant> productVariants) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        Set<ProductImage> productImages = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        if (CollectionUtils.isNotEmpty(productVariants)){
            this.sizeList = productVariants.stream().map(ProductVariant::getSize).distinct().toList();
            this.cornicioneTypeList = productVariants.stream().map(ProductVariant::getCornicioneType).map(CornicioneType::getCornicione).distinct().toList();
            this.toppingList = productVariants.stream().map(ProductVariant::getTopping).map(ToppingAndCheeseType::getToppingAndCheese).distinct().toList();
            this.cheeseList = productVariants.stream().map(ProductVariant::getCheese).map(ToppingAndCheeseType::getToppingAndCheese).distinct().toList();
            this.crustTypeList = productVariants.stream().map(ProductVariant::getCrustType).map(CrustType::getCrust).distinct().toList();
            this.price = productVariants.stream().map(ProductVariant::getPrice).distinct().toList();
        }
    }
}
