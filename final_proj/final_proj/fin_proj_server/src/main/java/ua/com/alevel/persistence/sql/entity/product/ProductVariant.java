package ua.com.alevel.persistence.sql.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.type.CrustType;
import ua.com.alevel.persistence.sql.type.ToppingAndCheeseType;
import ua.com.alevel.persistence.sql.type.CornicioneType;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "product_variants")
public class ProductVariant extends BaseEntity {

    private Integer size;

    private CornicioneType cornicioneType;

    private ToppingAndCheeseType topping;

    private ToppingAndCheeseType cheese;

    private CrustType crustType;

    private Boolean meat;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    private Product product;
}
