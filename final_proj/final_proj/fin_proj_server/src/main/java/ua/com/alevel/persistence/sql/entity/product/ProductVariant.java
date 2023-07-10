package ua.com.alevel.persistence.sql.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.type.CornicioneType;
import ua.com.alevel.persistence.sql.type.CrustType;
import ua.com.alevel.persistence.sql.type.ToppingAndCheeseType;

@Getter
@Setter
@Entity
@Table(name = "product_variants")
public class ProductVariant extends BaseEntity {

    private Integer size;

    @Enumerated(EnumType.STRING)
    @Column(name = "cornicione_type")
    private CornicioneType cornicioneType;

    @Enumerated(EnumType.STRING)
    private ToppingAndCheeseType topping;

    @Enumerated(EnumType.STRING)
    private ToppingAndCheeseType cheese;

    @Enumerated(EnumType.STRING)
    @Column(name = "crust_type")
    private CrustType crustType;

    @Column(nullable = false)
    private Integer price;

    private Boolean meat;

    @Column(nullable = false, unique = true)
    private Long code;

    @ManyToOne
    private Product product;
}
