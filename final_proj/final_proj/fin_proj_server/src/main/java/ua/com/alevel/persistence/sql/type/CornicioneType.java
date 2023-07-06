package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter
public enum CornicioneType {

    CHEESE_CORNER("Cheese corner"),
    HUNTERS_SAUSAGE_CORNER("Sausage corner"),
    VIENNA_SAUSAGES_CORNER("Vienna sausages corner");

    private final String corner;

    CornicioneType(String corner) {
        this.corner = corner;
    }
}
