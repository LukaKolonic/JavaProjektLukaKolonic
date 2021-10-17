/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author lukak
 */
public interface Repository<T> {
    int create(T obj) throws Exception;
    void create(List<T> obj) throws Exception;
    void update(int id, T data) throws Exception;
    void delete(int id) throws Exception;
    Optional<T> select(int id) throws Exception;
    List<T> select() throws Exception;   
    
}
