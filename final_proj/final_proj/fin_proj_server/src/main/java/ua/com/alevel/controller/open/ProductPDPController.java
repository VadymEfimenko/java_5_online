package ua.com.alevel.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.data.dto.product.ProductPDPDto;
import ua.com.alevel.data.dto.product.ProductSearchDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.pdp.ProductPDPFacade;
import ua.com.alevel.persistence.sql.type.CornicioneType;
import ua.com.alevel.persistence.sql.type.CrustType;
import ua.com.alevel.persistence.sql.type.ToppingAndCheeseType;

@RestController
@RequestMapping("/api/open/products/{id}/pdp")
public class ProductPDPController {

    private final ProductPDPFacade productPDPFacade;

    public ProductPDPController(ProductPDPFacade productPDPFacade) {
        this.productPDPFacade = productPDPFacade;
    }

    @GetMapping
    public ResponseEntity<DataContainer<ProductPDPDto>> findByProduct(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(productPDPFacade.findById(id)));
    }

    @GetMapping("/variants")
    public ResponseEntity<DataContainer<Long>> findProductIdByVariants(
            @PathVariable Long id,
            @RequestParam Integer size,
            @RequestParam String cornicioneType,
            @RequestParam String topping,
            @RequestParam String cheese,
            @RequestParam String crustType
    ) {
        ProductSearchDto dto = ProductSearchDto
                .builder()
                .size(size)
                .cornicioneType(CornicioneType.findByType(cornicioneType))
                .topping(ToppingAndCheeseType.findByType(topping))
                .cheese(ToppingAndCheeseType.findByType(cheese))
                .crustType(CrustType.findByType(crustType))
                .productId(id)
                .build();
        return ResponseEntity.ok(new DataContainer<>(productPDPFacade.findProductIdByVariants(dto)));
    }
}
