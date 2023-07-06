package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.type.CrustType;
import ua.com.alevel.persistence.sql.type.ToppingAndCheeseType;
import ua.com.alevel.persistence.sql.type.CornicioneType;

@Getter
@Setter
@NoArgsConstructor
public class ProductVariantDto extends BaseDto {

    private Integer size;

    private CornicioneType cornicioneType;

    private ToppingAndCheeseType topping;

    private ToppingAndCheeseType cheese;

    private CrustType crustType;

    private Boolean meat;

    public ProductVariantDto(ProductVariant productVariant){
        setId(productVariant.getId());
        this.size = productVariant.getSize();
        this.cornicioneType = productVariant.getCornicioneType();
        this.topping = productVariant.getTopping();
        this.cheese = productVariant.getCheese();
        this.crustType = productVariant.getCrustType();
        this.meat = productVariant.getMeat();
    }
}
