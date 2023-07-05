package ua.com.alevel.persistence.sql.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.type.Crust;
import ua.com.alevel.persistence.sql.type.ToppingAndCheese;
import ua.com.alevel.persistence.sql.type.СornicioneType;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "product_variants")
public class ProductVariant extends BaseEntity {

    private Integer size;

    private СornicioneType сornicioneType;

    private ToppingAndCheese topping;

    private ToppingAndCheese cheese;

    private Crust crust;

    private Boolean meat;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    private Product product;
}
