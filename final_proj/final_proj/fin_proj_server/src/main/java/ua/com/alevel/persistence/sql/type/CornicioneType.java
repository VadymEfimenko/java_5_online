package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter
public enum CornicioneType {

    CHEESE_CORNICIONE("Cheese cornicione"),
    HUNTERS_SAUSAGE_CORNICIONE("Sausage cornicione"),
    VIENNA_SAUSAGES_CORNICIONE("Vienna sausages cornicione");

    private final String cornicione;

    CornicioneType(String cornicione) {
        this.cornicione = cornicione;
    }
}
