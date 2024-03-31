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

    public void OperationSelection(UserRepository userRepository) {
        this.userRepository = userRepository;
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println(" Select Operation to Perform ");
            System.out.println("Enter 1 for Create ");
            System.out.println("Enter 2 for View ");
            System.out.println("Enter 3 for Edit ");
            System.out.println("Enter 4 for Delete ");
            System.out.println("Enter 5 for Exit ");

            System.out.println("Enter your choice : ");
            choice = sc.next();
            switch (choice) {
                case "1":
                    Create();
                    break;
                case "2":
                    ShowAll();
                    break;
                case "3":
                    Edit();
                    break;
                case "4":
                    Delete();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option !! please choose another option!!");
                    break;
            }
        } while (!choice.equals("0"));
    }

    public static void Create() {
        String username = null;
        String email = null;
        String password = null;
        Long id = null;
        Scanner sc = new Scanner(System.in);

        while (id == null) {
            System.out.println("Enter id:");
            id = sc.nextLong();
        }
        while (username == null || username.isEmpty()) {
            System.out.println("Enter username:");
            username = sc.next();
        }
        while (email == null || email.isEmpty()) {
            System.out.println("Enter email:");
            email = sc.next();
        }
        while (password == null || password.isEmpty()) {
            System.out.println("Enter password:");
            password = sc.next();
        }
        User user = new User(id, username, email, password);
        userRepository.Create(user);

    }

    public static void ShowAll() {
        userRepository.ShowAll().stream().forEach(x -> System.out.println(x));
    }

    public static void Edit() {
        String username = null;
        String email = null;
        String password = null;
        Long id = null;
        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter id to Edit User : ");
            id = sc.nextLong();
        }
        User user = userRepository.ShowById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found!!");
        } else {
            while (username == null || username.isEmpty()) {
                System.out.println("Enter username:");
                username = sc.next();
            }
            while (email == null || email.isEmpty()) {
                System.out.println("Enter email:");
                email = sc.next();
            }
            while (password == null || password.isEmpty()) {
                System.out.println("Enter password:");
                password = sc.next();
            }
        }
        User u = new User(id, username, email, password);
        userRepository.Edit(u);
    }

    public static void Delete() {
        Long id = null;
        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter id to Delete User : ");
            id = sc.nextLong();
        }
        User user = userRepository.ShowById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found!!");
        } else {
            userRepository.Delete(user);
        }
    }
}
