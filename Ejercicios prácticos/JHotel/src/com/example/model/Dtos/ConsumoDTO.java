/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model.Dtos;

/**
 *
 * @author Martin
 */
public class ConsumoDTO {
    private int idHabitacion;
    private String denominacion;
    private float total;
    private int cantidad;

    public ConsumoDTO(int idHabitacion, String denominacion, float total, int cantidad) {
        this.idHabitacion = idHabitacion;
        this.denominacion = denominacion;
        this.total = total;
        this.cantidad = cantidad;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Nº" + idHabitacion + " |" + denominacion + " |Total $: " + total + " |Servicios: " + cantidad;
    }
    
}
