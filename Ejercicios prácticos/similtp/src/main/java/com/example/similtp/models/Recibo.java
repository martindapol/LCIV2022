/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.similtp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Entity
@Table(name = "recibos")

public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_recibo")
    private int nroRecibo;
    private int mes;
    private int anio;
    @Column(name = "monto_antig")
    private double antiguedad;
    private double jubilacion;
    @Column(name = "obra_social")
    private double obraSocial;
    @Column(name = "fondo_complej")
    private double fondoComplejidad;

    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "legajo")
    @JsonBackReference
    private Empleado empleado;
}
