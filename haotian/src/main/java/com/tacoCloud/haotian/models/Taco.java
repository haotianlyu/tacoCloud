package com.tacoCloud.haotian.models;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Taco")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @Column(name="created_at")
    private Date createdAt;

    @NotNull(message="You must choose at least 1 ingredient")
    @ManyToMany(targetEntity = Ingredient.class)
    @JoinTable(name = "taco_ingredients",
        joinColumns = @JoinColumn(name = "taco_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    )
    private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

}
