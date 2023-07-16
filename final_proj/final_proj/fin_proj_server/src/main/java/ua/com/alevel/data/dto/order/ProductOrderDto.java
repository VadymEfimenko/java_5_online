package ua.com.alevel.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.sql.entity.product.Product;

import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;


import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductOrderDto {

    private Long id;
    private String name;
    private Integer price;
    private Integer size;
    private String cornicioneType;
    private String topping;
    private String cheese;
    private String crustType;
    private String image;
    
    private Integer quantity;

    public ProductOrderDto(ProductVariant productVariant) {
        this.id = productVariant.getId();
        this.name = productVariant.getProduct().getName();
        this.size = productVariant.getSize();
        this.price = productVariant.getPrice();
        this.cornicioneType = productVariant.getCornicioneType().getCornicione();
        this.topping = productVariant.getTopping().getToppingAndCheese();
        this.cheese = productVariant.getCheese().getToppingAndCheese();
        this.crustType = productVariant.getCrustType().getCrust();
        Set<ProductImage> productImages = productVariant.getProduct().getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            ProductImage productImage = productImages
                    .stream()
                    .filter(ProductImage::getMainImage)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("main image not found"));
            this.image = productImage.getImageUrl();
        }
    }
}
