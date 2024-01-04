package com.Eccomerce.backend.DTO;

import java.util.List;

// import com.Eccomerce.backend.Entity.Items;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ManyToMany;

public class CartDto {
    private Integer id;
    @JsonIgnore
    private UserDto user;

    @ManyToMany
    private List<ItemDto> item_array;

    public CartDto() {

    }

    public CartDto(UserDto user, List<ItemDto> items) {

        this.item_array = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemDto> getItem_array() {
        return item_array;
    }

    public void setItem_array(List<ItemDto> item_array) {
        this.item_array = item_array;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
