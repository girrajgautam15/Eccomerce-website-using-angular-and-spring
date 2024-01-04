package com.Eccomerce.backend.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {

    private Integer id;
    private String name;
    private String username;
    private String password;
    @JsonIgnore
    private CartDto cart;

    public UserDto() {

    }

    public UserDto(String name, CartDto cart) {

        this.name = name;
        this.cart = cart;
    }

    public Integer getID() {

        return this.id;
    }

    public void setID(Integer id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }
}
