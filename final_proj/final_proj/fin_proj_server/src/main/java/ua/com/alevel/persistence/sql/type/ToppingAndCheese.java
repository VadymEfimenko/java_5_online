package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter
public enum ToppingAndCheese {

    STANDARD("Standard"), DOUBLE("Double");

    private final String topping;

    ToppingAndCheese(String toppingAndCheese) {
        this.topping = toppingAndCheese;
    }
}
