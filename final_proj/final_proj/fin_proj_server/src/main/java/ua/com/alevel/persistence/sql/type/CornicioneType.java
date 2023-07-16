package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CornicioneType {

    CHEESE_CORNICIONE("Cheese cornicione"),
    HUNTERS_SAUSAGE_CORNICIONE("Sausage cornicione"),
    VIENNA_SAUSAGES_CORNICIONE("Vienna sausages cornicione");

    private final String cornicione;

    CornicioneType(String cornicione) {
        this.cornicione = cornicione;
    }

    public static CornicioneType findByType(String cornicione) {
        return Arrays
                .stream(CornicioneType.values()).filter(cornicioneType -> cornicioneType.getCornicione().equals(cornicione))
                .findFirst()
                .get();
    }
}
