package ua.com.alevel.entity;

import lombok.ToString;

@ToString(callSuper = true)
public class Course extends BaseEntity {

    private String title;

    private Integer mouthDuration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMouthDuration() {
        return mouthDuration;
    }

    public void setMouthDuration(Integer mouthDuration) {
        this.mouthDuration = mouthDuration;
    }
}
