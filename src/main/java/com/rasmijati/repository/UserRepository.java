/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserRepository {

    List<User> list;

    public UserRepository() {
        this.list = new ArrayList<>();
    }

    public void Create(User u) {
        this.list.add(u);
    }

    public List<User> ShowAll() {
        return this.list;
    }

    public User ShowById(Long id) {
        for (User u : list) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void Delete(User u) {
        this.list.remove(u);
    }

    public void Edit(User u) {
        this.list.stream().filter(x -> x.getId().equals(u.getId())).forEach(n -> {
            n.setUsername(u.getUsername());
            n.setEmail(u.getEmail());
            n.setPassword(u.getPassword());
        });
    }
}
