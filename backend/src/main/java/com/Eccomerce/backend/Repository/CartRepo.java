package com.Eccomerce.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Eccomerce.backend.Entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
