package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter
public enum Crust {
    SPICY("Spicy"), CREAMY("Creamy"), CAESAR("Caesar");

    private final String crust;

    Crust(String crust) {
        this.crust = crust;
    }
}
