/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.productosCrud.data;

import com.example.productosCrud.data.exceptions.DaoException;
import com.example.productosCrud.domains.Producto;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface ProductoDao {
    List<Producto> getAll() throws DaoException;
    Producto getbyId(int id) throws DaoException ;
    boolean save(Producto producto) throws DaoException; //insert or update
    boolean delete(int id)  throws DaoException;
}
