package ua.com.alevel.persistence.sql.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.sql.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "main_image", nullable = false)
    private Boolean mainImage;

    private String name;

    @ManyToMany(mappedBy = "productImages")
    private Set<Product> products = new HashSet<>();

    public ProductImage() {
        super();
        this.mainImage = false;
    }
}
