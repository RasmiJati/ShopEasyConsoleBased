/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.repository.UserRepository;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class UserController {

    private static UserRepository userRepository;
    private static User user;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username;
        String email;
        String password;
        Long id;
        System.out.println("Enter id:");
        id = sc.nextLong();
        System.out.println("Enter username:");
        username = sc.next();
        System.out.println("Enter email:");
        email = sc.next();
        System.out.println("Enter password:");
        password = sc.next();

        user = new User(id, username, email, password);
        userRepository = new UserRepository();
        userRepository.Create(user);
        System.out.println("Created!!");

        System.out.println(userRepository.ShowAll());

        user.setId(2L);
        user.setUsername("rj");
        user.setEmail("rj@gmail");
        user.setPassword("rj123");
        userRepository.Edit(user);
        System.out.println(userRepository.ShowAll());
        System.out.println("Edited");

//        System.out.println("By id : " + userRepository.ShowById(1L));
        System.out.println("By id : " + userRepository.ShowById(2L));

        userRepository.Delete(user);
        System.out.println(userRepository.ShowAll());
        System.out.println("Deleted");
    }
}
