/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Martin
 */
public class Habitacion {
    private int nroHabitacion;
    private String denominacion;

    public Habitacion(int nroHabitacion, String denominacion) {
        this.nroHabitacion = nroHabitacion;
        this.denominacion = denominacion;
    }
    
    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return String.valueOf(nroHabitacion);
    }
    
    
}
