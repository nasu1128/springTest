package com.example.demo.product;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Integer type;
    private String description;
    private Boolean isDeleted;


    public Product(String name,
                   Integer type,
                   String description) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.isDeleted = false;
    }

    public Product(
            Integer id,
            String name,
            Integer type,
            String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.isDeleted = false;
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
                ", isDeleted=" + isDeleted +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
