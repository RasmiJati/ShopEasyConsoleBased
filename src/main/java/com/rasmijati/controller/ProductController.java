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

    public static void main(String[] args) {
        productRepository = new ProductRepository();
        String name, description, image;
        BigDecimal price;
        Long id;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id : ");
        id = sc.nextLong();

        System.out.println("Enter name : ");
        name = sc.next();

        System.out.println("Enter desciption : ");
        description = sc.next();

        System.out.println("Enter price : ");
        price = new BigDecimal(sc.next());

        System.out.println("Enter image : ");
        image = sc.next();

        Product p = new Product(id, name, description, price, image);
        productRepository.Create(p);
        System.out.println(productRepository.ShowAll());

        p.setId(2L);
        p.setName("fjhdbjf");
        p.setDescription("sdjvcdj");
        p.setPrice(new BigDecimal(12356));
        p.setImage("dfhjgf");
        productRepository.Edit(p);
        System.out.println(productRepository.ShowAll());

        System.out.println(productRepository.ShowById(2L));
        productRepository.Delete(p);
        System.out.println(productRepository.ShowAll());
    }

}
