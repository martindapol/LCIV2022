/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productosCrud.domains;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 *
 * @author Martin
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_productos")
public class Producto {
    @Id
    @Column(name="id_producto")
    private int productoNro;
    @Column(name="n_producto")
    private String nombre;
    @Column(name="precio")
    private float precio;
    @Column(name="fecha_baja")
    private Date fechaBaja;
}
/**
 * 
 */