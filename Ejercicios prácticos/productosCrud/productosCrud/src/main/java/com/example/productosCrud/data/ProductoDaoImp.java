/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productosCrud.data;

import com.example.productosCrud.data.exceptions.DaoException;
import com.example.productosCrud.domains.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Setter
public class ProductoDaoImp implements ProductoDao{

    @Autowired
    private DataSource dataSource;
    
    @Override
    public List<Producto> getAll() throws DaoException{
        List<Producto> lst = new ArrayList<>();
        final String query = "SELECT * FROM t_productos";
        
        try(Connection cnn = dataSource.getConnection(); Statement smt = cnn.createStatement(); ResultSet rs =  smt.executeQuery(query)) {
            while(rs.next()){
                lst.add(mapProducto(rs));
            }
            
        } catch (SQLException e) {
            throw new DaoException("Error de datos", e);
        }
        
        return lst;
    }

    @Override
    public Producto getbyId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Producto mapProducto(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_producto");
        String nombre= rs.getString("n_producto");
        float precio = rs.getFloat("precio");
        Date fecha = rs.getDate("fecha_baja");
        
        return new Producto(id, nombre, precio, fecha);
    }
    
}
