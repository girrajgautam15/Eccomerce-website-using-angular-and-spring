package com.Eccomerce.backend.Service;

// import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Eccomerce.backend.DTO.CartDto;
import com.Eccomerce.backend.DTO.ItemDto;
import com.Eccomerce.backend.DTO.UserDto;
import com.Eccomerce.backend.Entity.Cart;
import com.Eccomerce.backend.Entity.Items;
import com.Eccomerce.backend.Entity.User;
import com.Eccomerce.backend.Repository.CartRepo;
import com.Eccomerce.backend.Repository.ItemRepo;
import com.Eccomerce.backend.Repository.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;

    private final ItemRepo itemRepo;
    private final CartRepo cartRepo;
    private final ModelMapper modelMapper;

    public UserService(UserRepo userRepo, ItemRepo itemRepo, CartRepo cartRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.itemRepo = itemRepo;
        this.cartRepo = cartRepo;
        this.modelMapper = modelMapper;
    }

    public UserDto extractedUserDTO(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }

    public User extractedUser(UserDto user) {
        return this.modelMapper.map(user, User.class);
    }

    public ItemDto extractedItemDTO(Items items) {
        return this.modelMapper.map(items, ItemDto.class);
    }

    public Items extractedItems(ItemDto items) {
        return this.modelMapper.map(items, Items.class);
    }

    public CartDto extractedCartDTO(Cart cart) {
        return this.modelMapper.map(cart, CartDto.class);
    }

    public Cart extractedCart(CartDto cart) {
        return this.modelMapper.map(cart, Cart.class);
    }

    public UserDto getUser(Integer id) {
        User user = this.userRepo.findById(id).get();
        return extractedUserDTO(user);
    }

    public CartDto getCart(String username) {
        User user = this.userRepo.findByUsername(username);

        Cart cart = user.getCart();

        return extractedCartDTO(cart);

    }

    public List<Items> getAllItems() {
        return this.itemRepo.findAll();
    }

    public CartDto addTocart(String username, Integer item_id) {

        Items item = this.itemRepo.findById(item_id).get();
        User user = this.userRepo.findByUsername(username);
        Cart cart = user.getCart();
        List<Cart> carts = item.getCart();
        List<Items> items = cart.getItem_array();
        items.add(item);
        carts.add(cart);
        cart.setItem_array(items);
        item.setCart(carts);
        this.cartRepo.save(cart);
        this.itemRepo.save(item);
        return extractedCartDTO(user.getCart());
        // return extractedCartDTO(cart);

    }

    public CartDto DeleteFromCart(String username, Integer item_id) {
        Items item = this.itemRepo.findById(item_id).get();
        User user = this.userRepo.findByUsername(username);
        Cart cart = user.getCart();
        List<Cart> carts = item.getCart();
        List<Items> items = cart.getItem_array();
        items.remove(item);
        carts.remove(cart);
        cart.setItem_array(items);
        item.setCart(carts);
        this.cartRepo.save(cart);
        this.itemRepo.save(item);
        return extractedCartDTO(user.getCart());
    }

    public UserDto saveUser(UserDto user) {
        User us = this.userRepo.save(extractedUser(user));
        Cart cart = new Cart();
        us.setCart(cart);
        return (extractedUserDTO(us));

    }

    public UserDto getByUsername(String username) {
        return extractedUserDTO(this.userRepo.findByUsername(username));
    }
}
