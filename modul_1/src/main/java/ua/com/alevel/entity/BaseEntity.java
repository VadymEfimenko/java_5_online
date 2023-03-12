package ua.com.alevel.entity;

import lombok.ToString;

@ToString
public abstract class BaseEntity {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
