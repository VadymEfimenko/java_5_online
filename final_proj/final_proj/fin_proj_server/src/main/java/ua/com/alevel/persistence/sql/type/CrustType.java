package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CrustType {
    SPICY("Spicy"), CREAMY("Creamy"), CAESAR("Caesar");

    private final String crust;

    CrustType(String crust) {
        this.crust = crust;
    }

    public static CrustType findByType(String crustType) {
        return Arrays
                .stream(CrustType.values()).filter(crust -> crust.getCrust().equals(crustType))
                .findFirst()
                .get();
    }
}
