package ua.com.alevel.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "operations")
@Entity
public class Operation extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "account_from")
    private Account accountFrom;

    @OneToOne()
    @JoinColumn(name = "account_to")
    private Account accountTo;

    private Long sum;

    private String category;
}
