/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productosCrud.data;

import com.example.productosCrud.data.exceptions.DaoException;
import com.example.productosCrud.domains.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ProductoDaoImp implements ProductoDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Producto> getAll() throws DaoException {
        List<Producto> lst = new ArrayList<>();
        final String query = "SELECT * FROM t_productos";

        try ( Connection cnn = dataSource.getConnection();  Statement smt = cnn.createStatement();  ResultSet rs = smt.executeQuery(query)) {
            while (rs.next()) {
                lst.add(mapProducto(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Error de datos", e);
        }

        return lst;
    }

    @Override
    public Producto getbyId(int id) throws DaoException {
        Producto found = null;
        final String query = "SELECT * FROM t_productos WHERE id_producto = ?";

        try ( Connection cnn = dataSource.getConnection();  PreparedStatement ps = cnn.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                found = mapProducto(rs);
            }
            rs.close();

        } catch (SQLException e) {
            throw new DaoException("Error de datos", e);
        }

        return found;
    }

    @Override
    public boolean save(Producto producto) throws DaoException {
        boolean isNew = false;
        Producto aux = getbyId(producto.getProductoNro());
        String query;
        int rows = 0;
        
        if (aux == null) { // INSERT INTO
            query = "INSERT INTO t_productos (n_producto, precio) VALUES(?,?);";
            isNew = true;
        } else { // UPDATE
            query = "UPDATE t_productos SET n_producto=?, precio=? WHERE id_producto=?";
        }

        try ( Connection cnn = dataSource.getConnection();  PreparedStatement ps = cnn.prepareStatement(query);) {
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecio());
            
            if (!isNew) {
                ps.setInt(3, producto.getProductoNro());
            }

            rows = ps.executeUpdate();            
        } catch (Exception e) {
        }
        return (rows == 1);
    }

    @Override
    public boolean delete(int id) throws DaoException{
        final String query = "UPDATE t_productos SET fecha_baja = NOW() WHERE id_producto = ?";
        int rows = 0;
        try ( Connection cnn = dataSource.getConnection();  PreparedStatement ps = cnn.prepareStatement(query);) {
            ps.setInt(1, id);
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error de datos", e);
        }

        return rows == 1;
    }

    private Producto mapProducto(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_producto");
        String nombre = rs.getString("n_producto");
        float precio = rs.getFloat("precio");
        Date fecha = rs.getDate("fecha_baja");

        return new Producto(id, nombre, precio, fecha);
    }
}
