package com.tacoCloud.haotian.models;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @ManyToOne
    private User user;

    //end::allButValidation[]
    @NotBlank(message="Name is required")
    //tag::allButValidation[]
    private String name;
    //end::allButValidation[]

    @NotBlank(message="Street is required")
    //tag::allButValidation[]
    private String street;
    //end::allButValidation[]

    @NotBlank(message="City is required")
    //tag::allButValidation[]
    private String city;
    //end::allButValidation[]

    @NotBlank(message="State is required")
    //tag::allButValidation[]
    private String state;
    //end::allButValidation[]

    @NotBlank(message="Zip code is required")
    //tag::allButValidation[]
    private String zip;
    //end::allButValidation[]

    @CreditCardNumber(message="Not a valid credit card number")
    //tag::allButValidation[]
    //379354508162306
    private String ccNumber;
    //end::allButValidation[]

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    //tag::allButValidation[]
    private String ccExpiration;
    //end::allButValidation[]

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    //tag::allButValidation[]
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    @JoinTable(name = "TACO_ORDER_TACOS",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "taco_id", referencedColumnName = "id")
    )
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    public void placedAt() {
        this.placedAt = new Date();
    }
}
//end::allButValidation[]
//end::all[]
