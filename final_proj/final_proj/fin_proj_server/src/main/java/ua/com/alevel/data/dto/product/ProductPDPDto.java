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
    private String price = "100.00";
    private Integer size;
    private CornicioneType cornicioneType;
    private ToppingAndCheeseType topping;
    private ToppingAndCheeseType cheese;
    private CrustType crustType;
    private String meat;

    public ProductPDPDto(Product product, ProductVariant productVariant) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        Set<ProductImage> productImages = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        this.size = productVariant.getSize();
        this.cornicioneType = productVariant.getCornicioneType();
        this.topping = productVariant.getTopping();
        this.cheese = productVariant.getCheese();
        this.crustType = productVariant.getCrustType();
        this.meat = productVariant.getMeat() ? "with meat" : "without meat";
    }
}
