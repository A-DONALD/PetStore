package org.esaip.ir42324.donald.Object;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PETSTORE")
public class PetStore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MANAGERNAME")
    private String managerName;
    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private Address address;
    @ManyToMany
    @JoinTable(
            name = "PETSTORE_PRODUCT",
            joinColumns = @JoinColumn(name = "PETSTORE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
    )
    private Set<Product> products;
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animals;
    {
        animals = new HashSet<>();
        products = new HashSet<>();
    }

    public PetStore() {}

    public PetStore(long id, String name, String managerName, Address address, Set<Product> products, Set<Animal> animals) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
        this.address = address;
        this.products = products;
        this.animals = animals;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}
