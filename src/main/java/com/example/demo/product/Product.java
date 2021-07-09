package com.example.demo.product;

import javax.persistence.*;


@Table
@Entity(name = "productTable")
public class Product {

    @Id
    @SequenceGenerator(
            name = "id",
            sequenceName = "id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id"
    )
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private Integer type;
    @Column(name = "description")
    private String description;



    public Product(String name,
                   Integer type,
                   String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Product(
            long id,
            String name,
            Integer type,
            String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
