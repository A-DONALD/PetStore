package org.esaip.ir42324.donald.Object;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "LABEL")
    private String label;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private ProdType type;
    @Column(name = "PRICE")
    private double price;
    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores;
    {
        petStores = new HashSet<>();
    }

    public Product() {}

    public Product(long id, String code, String label, ProdType type, double price, Set<PetStore> petStores) {
        this.id = id;
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.petStores = petStores;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }
}
