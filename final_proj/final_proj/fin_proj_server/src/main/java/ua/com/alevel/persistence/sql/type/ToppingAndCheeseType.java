package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter
public enum ToppingAndCheeseType {

    STANDARD("Standard"), DOUBLE("Double");

    private final String topping;

    ToppingAndCheeseType(String toppingAndCheese) {
        this.topping = toppingAndCheese;
    }
}
