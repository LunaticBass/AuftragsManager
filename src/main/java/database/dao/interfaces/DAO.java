/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao.interfaces;

import java.util.List;

/**
 *
 * @author Nagy
 */
public interface DAO<T> {
    public List<T> findAll();    
    public void save(T k);      
    public void delete(int id);   
    public void close();
}
