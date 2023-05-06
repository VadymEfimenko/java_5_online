package ua.com.alevel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Course extends BaseEntity {

    private String title;

    private Integer mouthDuration;

}
