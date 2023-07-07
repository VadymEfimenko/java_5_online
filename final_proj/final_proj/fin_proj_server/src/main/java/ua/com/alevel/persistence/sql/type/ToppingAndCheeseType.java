package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter
public enum ToppingAndCheeseType {

    STANDARD("Standard"), DOUBLE("Double");

    private final String toppingAndCheese;

    ToppingAndCheeseType(String toppingAndCheese) {
        this.toppingAndCheese = toppingAndCheese;
    }
}
