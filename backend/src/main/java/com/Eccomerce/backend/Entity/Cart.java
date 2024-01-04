package com.Eccomerce.backend.Entity;

import jakarta.persistence.OneToOne;

import java.util.List;

// import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @JsonIgnore
    @OneToOne
    private User user;

    @ManyToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Items> item_array;

    public Cart() {

    }

    public Cart(User user, List<Items> items) {

        this.item_array = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Items> getItem_array() {
        return this.item_array;
    }

    public void setItem_array(List<Items> item_array) {
        this.item_array = item_array;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
