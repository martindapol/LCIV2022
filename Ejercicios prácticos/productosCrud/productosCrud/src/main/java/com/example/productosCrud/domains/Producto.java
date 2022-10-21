/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productosCrud.domains;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Martin
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private int productoNro;
    private String nombre;
    private float precio;
    private Date fecha_baja;
}
/**
 * 
 */