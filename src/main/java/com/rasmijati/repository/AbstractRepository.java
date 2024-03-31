/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.IEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public abstract class AbstractRepository<T extends IEntity> {

    List<T> list;

    public AbstractRepository() {
        list = new ArrayList<>();
    }

    public void Create(T t) {
        this.list.add(t);
    }

    public List<T> ShowAll() {
        return list;
    }

    public T ShowById(Long id) {
        for (T t : list) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public void Delete(T t) {
        this.list.remove(t);
    }

    public void Edit(T t) {

    }

}
