/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Product;

/**
 *
 * @author admin
 */
public class ProductRepository extends AbstractRepository<Product> {

    @Override
    public void Edit(Product p) {
        ShowAll().stream().filter(x -> x.getId().equals(p.getId())).forEach(n -> {
            n.setId(p.getId());
            n.setName(p.getName());
            n.setDescription(p.getDescription());
            n.setPrice(p.getPrice());
            n.setImage(p.getImage());
        });
    }
}
