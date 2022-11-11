/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productosCrud.data;

import com.example.productosCrud.data.exceptions.DaoException;
import com.example.productosCrud.domains.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Martin
 */
@Repository
public class ProductoDaoJPA implements ProductoDao {
//public class ProductoDaoJPA{
    @PersistenceContext
    private EntityManager em;

   
    public List<Producto> getAll() throws DaoException {
        return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }

    @Override
    public Producto getbyId(int id) throws DaoException {
        return em.find(Producto.class, id);
    }

    @Override
    @Transactional
    public boolean save(Producto producto) throws DaoException {
        try {
            Producto entity = this.getbyId(producto.getProductoNro());
            if(entity == null){
                em.persist(producto);
            }else{
                entity.setNombre(producto.getNombre());
                entity.setPrecio(producto.getPrecio());
                entity.setFechaBaja(producto.getFechaBaja());
                em.merge(entity);
            }
        } catch (Exception ex) {
            throw new DaoException("Error de datos!", ex);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean delete(int id) throws DaoException {
        try {
            Producto entity = this.getbyId(id);
            em.remove(entity);
        } catch (Exception e) {
            throw new DaoException("Error de datos!", e);
        }
        return true;
    }

}
