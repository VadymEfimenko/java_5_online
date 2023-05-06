package ua.com.alevel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer year;
}
