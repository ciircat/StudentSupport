package com.ciircat.studentsupport.service;

import java.util.Set;

/*
 * Generické rozhraní které má nějaký typ T a datový typ id ID, což bude nejspíše Long
 * ale díky genericitě to bude moci být třeba Int
 * */
public interface CrudServiceInterface<T, ID>{
    public T findById(ID id);

    public T save(T t);

    public Set<T> findAll();

    public void deleteById(ID id);

    public void delete(T t);
}
