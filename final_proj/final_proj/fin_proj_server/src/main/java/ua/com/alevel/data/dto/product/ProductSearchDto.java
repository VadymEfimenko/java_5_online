package ua.com.alevel.data.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.alevel.persistence.sql.type.CornicioneType;
import ua.com.alevel.persistence.sql.type.CrustType;
import ua.com.alevel.persistence.sql.type.ToppingAndCheeseType;

@Getter
@Setter
@Builder
public class ProductSearchDto {

    
    Long productId;
    
    Integer size;
    
    CornicioneType cornicioneType;
    
    ToppingAndCheeseType topping;

    ToppingAndCheeseType cheese;
    
    CrustType crustType;
}
