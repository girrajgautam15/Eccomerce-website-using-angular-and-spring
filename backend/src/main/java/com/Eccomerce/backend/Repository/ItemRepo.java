package com.Eccomerce.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Eccomerce.backend.Entity.Items;

public interface ItemRepo extends JpaRepository<Items, Integer> {

}
