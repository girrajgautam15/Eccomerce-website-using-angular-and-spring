package com.Eccomerce.backend.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.ManyToMany;

public class ItemDto {
    private Integer id;
    private String name;
    private Integer price;

    @JsonIgnore
    private List<CartDto> cart;

    public ItemDto() {
    }

    public ItemDto(String name, Integer price, List<CartDto> cart) {
        this.name = name;
        this.price = price;
        this.cart = cart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<CartDto> getCart() {
        return cart;
    }

    public void setCart(List<CartDto> cart) {
        this.cart = cart;
    }
}
