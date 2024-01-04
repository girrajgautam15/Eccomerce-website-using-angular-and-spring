package com.Eccomerce.backend.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Eccomerce.backend.DTO.CartDto;
import com.Eccomerce.backend.DTO.UserDto;
import com.Eccomerce.backend.Entity.Items;
import com.Eccomerce.backend.Service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("details")
public class AppController {
    @Autowired
    UserService userService;

    @PostMapping("save")
    public UserDto saveUser(@RequestBody UserDto user) {

        return this.userService.saveUser(user);
    }

    // @GetMapping("/{id}")
    // public UserDto getUser(@PathVariable Integer id) {

    // }

    @GetMapping("/{username}/cart")
    public CartDto getCart(@PathVariable String username) {

        return this.userService.getCart(username);
    }

    @PutMapping("/{username}/cart/add/{item_id}")
    public CartDto addToCart(@PathVariable String username, @PathVariable Integer item_id) {

        return this.userService.addTocart(username, item_id);
    }

    @GetMapping("/items")
    public List<Items> getAllItems() {
        return this.userService.getAllItems();
    }

    @GetMapping("/{name}")
    public UserDto getByUsername(@PathVariable String name) {
        return this.userService.getByUsername(name);
    }

    @DeleteMapping("/{username}/cart/delete/{item_id}")
    public CartDto DeleteFromCart(@PathVariable String username, @PathVariable Integer item_id) {

        return this.userService.DeleteFromCart(username, item_id);
    }
}
