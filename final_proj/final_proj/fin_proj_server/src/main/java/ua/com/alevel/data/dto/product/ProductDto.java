package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.product.Product;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto extends BaseDto {

    private String name;
    private String description;

    public ProductDto(Product product) {
        setId(product.getId());
        this.name = product.getName();
        this.description = product.getDescription();
    }
}
