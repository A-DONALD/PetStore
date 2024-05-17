package org.esaip.ir42324.donald.Object;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "FISH")
public class Fish extends Animal implements Serializable {
    @Enumerated(EnumType.STRING)
    @Column(name = "LIVING_ENV")
    private FishLivEnv livingEnv;

    public Fish() {}

    public Fish(long id, LocalDate birth, String color, PetStore petStore, FishLivEnv livingEnv) {
        super(id, birth, color, petStore);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
