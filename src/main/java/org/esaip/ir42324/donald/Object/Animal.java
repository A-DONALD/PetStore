package org.esaip.ir42324.donald.Object;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "BIRTH")
    private LocalDate birth;
    @Column(name = "COLOR")
    private String color;
    @ManyToOne
    @JoinColumn(name = "PETSTORE_ID")
    private PetStore petStore;

    public Animal() {}

    public Animal(long id, LocalDate birth, String color, PetStore petStore) {
        this.id = id;
        this.birth = birth;
        this.color = color;
        this.petStore = petStore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}

