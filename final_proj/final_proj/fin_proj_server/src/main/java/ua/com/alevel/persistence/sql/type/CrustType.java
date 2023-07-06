package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter
public enum CrustType {
    SPICY("Spicy"), CREAMY("Creamy"), CAESAR("Caesar");

    private final String crust;

    CrustType(String crust) {
        this.crust = crust;
    }
}
