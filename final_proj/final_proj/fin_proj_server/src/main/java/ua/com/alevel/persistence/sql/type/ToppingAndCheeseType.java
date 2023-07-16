package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ToppingAndCheeseType {

    STANDARD("Standard"), DOUBLE("Double");

    private final String toppingAndCheese;

    ToppingAndCheeseType(String toppingAndCheese) {
        this.toppingAndCheese = toppingAndCheese;
    }

    public static ToppingAndCheeseType findByType(String toppingAndCheese) {
        return Arrays
                .stream(ToppingAndCheeseType.values()).filter(toppingAndCheeseType -> toppingAndCheeseType.getToppingAndCheese().equals(toppingAndCheese))
                .findFirst()
                .get();
    }
}
