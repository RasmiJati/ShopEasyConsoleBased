/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;

/**
 *
 * @author admin
 */
public class UserRepository extends AbstractRepository<User> {

    @Override
    public void Edit(User u) {
        ShowAll().stream().filter(x -> x.getId().equals(u.getId())).forEach(n -> {
            n.setUsername(u.getUsername());
            n.setEmail(u.getEmail());
            n.setPassword(u.getPassword());
        });
    }
}
