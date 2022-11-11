/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.similtp.repositories;

import com.example.similtp.models.Empleado;
import com.example.similtp.models.Recibo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Martin
 */
@Repository
public class EmpleadoRepositoryJPA implements EmpleadoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void createRecibo(Recibo recibo) {
       Empleado emp = em.find(Empleado.class, recibo.getEmpleado().getLegajo());
       emp.addRecibo(recibo);
       em.merge(recibo);
    }

}
