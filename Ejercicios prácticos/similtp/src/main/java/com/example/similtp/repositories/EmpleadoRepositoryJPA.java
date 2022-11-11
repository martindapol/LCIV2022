/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.similtp.repositories;

import com.example.similtp.models.Recibo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Martin
 */
public class EmpleadoRepositoryJPA implements EmpleadoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createRecibo(Recibo recibo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
