package org.esaip.ir42324.donald.Object;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "CAT")
public class Cat extends Animal implements Serializable {
    @Column(name = "CHIPID")
    private String chipId;

    public Cat() {}

    public Cat(long id, LocalDate birth, String color, PetStore petStore, String chipId) {
        super(id, birth, color, petStore);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
