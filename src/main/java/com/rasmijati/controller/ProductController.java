/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.Product;
import com.rasmijati.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ProductController {

    private static ProductRepository productRepository;

    public void OperationSelection(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
        String name = null;
        String description = null;
        BigDecimal price = null;
        String image = null;
        Long id = null;
        Scanner sc = new Scanner(System.in);

        while (id == null) {
            System.out.println("Enter id:");
            id = sc.nextLong();
        }
        while (name == null || name.isEmpty()) {
            System.out.println("Enter product name:");
            name = sc.next();
        }
        while (description == null || description.isEmpty()) {
            System.out.println("Enter description:");
            description = sc.next();
        }
        while (price == null) {
            System.out.println("Enter price:");
            price = new BigDecimal(sc.next());
        }
        while (image == null || image.isEmpty()) {
            System.out.println("Enter image:");
            image = sc.next();
        }
        Product product = new Product(id, name, description, price, image);
        productRepository.Create(product);

    }

    public static void ShowAll() {
        productRepository.ShowAll().stream().forEach(x -> System.out.println(x));
    }

    public static void Edit() {
        String name = null;
        String description = null;
        BigDecimal price = null;
        String image = null;
        Long id = null;
        Scanner sc = new Scanner(System.in);

        while (id == null) {
            System.out.println("Enter id to Edit Product : ");
            id = sc.nextLong();
        }
        Product product = productRepository.ShowById(id);
        if (product == null) {
            System.out.println("Product with id " + id + " not found!!");
        } else {
            while (name == null || name.isEmpty()) {
                System.out.println("Enter product name:");
                name = sc.next();
            }
            while (description == null || description.isEmpty()) {
                System.out.println("Enter description:");
                description = sc.next();
            }
            while (price == null) {
                System.out.println("Enter price:");
                price = new BigDecimal(sc.next());
            }
            while (image == null || image.isEmpty()) {
                System.out.println("Enter image:");
                image = sc.next();
            }
        }
        Product p = new Product(id, name, description, price, image);
        productRepository.Edit(p);
    }

    public static void Delete() {
        Long id = null;
        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter id to Delete Product : ");
            id = sc.nextLong();
        }
        Product product = productRepository.ShowById(id);
        if (product == null) {
            System.out.println("Product with id " + id + " not found!!");
        } else {
            productRepository.Delete(product);
        }
    }
}
