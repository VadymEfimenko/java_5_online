package ua.com.alevel.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "accounts")
public class Account extends BaseEntity{

    private Long balance;

    @Column(unique = true)
    private Long number;

    @ManyToOne
    private User user;
}
