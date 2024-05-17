package org.esaip.ir42324.donald;
import jakarta.persistence.*;
import org.esaip.ir42324.donald.Object.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main( String[] args ){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Création d'adresses
        Address address1 = new Address();
        address1.setNumber("123");
        address1.setStreet("Main Street");
        address1.setZipCode("12345");
        address1.setCity("Springfield");

        Address address2 = new Address();
        address2.setNumber("456");
        address2.setStreet("Oak Street");
        address2.setZipCode("67890");
        address2.setCity("Shelbyville");

        Address address3 = new Address();
        address3.setNumber("789");
        address3.setStreet("Pine Street");
        address3.setZipCode("13579");
        address3.setCity("Ogdenville");

        // Persisting addresses
        em.persist(address1);
        em.persist(address2);
        em.persist(address3);

        // Création de produits
        Product product1 = new Product();
        product1.setCode("P001");
        product1.setLabel("Dog Food");
        product1.setType(ProdType.FOOD);
        product1.setPrice(19.99);

        Product product2 = new Product();
        product2.setCode("P002");
        product2.setLabel("Cat Toy");
        product2.setType(ProdType.ACCESSORY);
        product2.setPrice(9.99);

        Product product3 = new Product();
        product3.setCode("P003");
        product3.setLabel("Aquarium Cleaner");
        product3.setType(ProdType.CLEANING);
        product3.setPrice(14.99);

        // Persisting products
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);

        // Création de PetStores
        Set<Product> products1 = new HashSet<>();
        products1.add(product1);
        products1.add(product2);

        Set<Product> products2 = new HashSet<>();
        products2.add(product2);
        products2.add(product3);

        PetStore petStore1 = new PetStore();
        petStore1.setName("Pet Heaven");
        petStore1.setManagerName("John Doe");
        petStore1.setAddress(address1);
        petStore1.setProducts(products1);

        PetStore petStore2 = new PetStore();
        petStore2.setName("Animal Kingdom");
        petStore2.setManagerName("Jane Smith");
        petStore2.setAddress(address2);
        petStore2.setProducts(products2);

        PetStore petStore3 = new PetStore();
        petStore3.setName("Furry Friends");
        petStore3.setManagerName("Jim Beam");
        petStore3.setAddress(address3);
        petStore3.setProducts(new HashSet<>());

        // Persisting pet stores
        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        // Ajout de produits aux PetStores
        product1.getPetStores().add(petStore1);
        product2.getPetStores().add(petStore1);
        product2.getPetStores().add(petStore2);
        product3.getPetStores().add(petStore2);

        // Persisting updated products
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);

        // Création d'animaux
        Cat cat1 = new Cat();
        cat1.setBirth(LocalDate.of(2020, 1, 1));
        cat1.setColor("Black");
        cat1.setPetStore(petStore1);
        cat1.setChipId("CHIP123");

        Cat cat2 = new Cat();
        cat2.setBirth(LocalDate.of(2019, 6, 15));
        cat2.setColor("White");
        cat2.setPetStore(petStore2);
        cat2.setChipId("CHIP456");

        Fish fish1 = new Fish();
        fish1.setBirth(LocalDate.of(2021, 3, 22));
        fish1.setColor("Gold");
        fish1.setPetStore(petStore3);
        fish1.setLivingEnv(FishLivEnv.FRESH_WATER);

        // Persisting animals
        em.persist(cat1);
        em.persist(cat2);
        em.persist(fish1);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
