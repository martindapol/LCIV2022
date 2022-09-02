/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.modelo;

/**
 *
 * @author Martin
 */
public class OrdenProduccion {
    private int id;
    private String fecha;
    private Responsable responsable;
    private Componente componente;
    private int cantidad;

    public OrdenProduccion(int id, String fecha, Responsable responsable, Componente componente, int cantidad) {
        this.id = id;
        this.fecha = fecha;
        this.responsable = responsable;
        this.componente = componente;
        this.cantidad = cantidad;
    }

    public OrdenProduccion(String fecha, Responsable responsable, Componente componente, int cantidad) {
        this.fecha = fecha;
        this.responsable = responsable;
        this.componente = componente;
        this.cantidad = cantidad;
    }



    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "OrdenProduccion{" + "id=" + id + ", fecha=" + fecha + ", responsable=" + responsable + ", componente=" + componente + ", cantidad=" + cantidad + '}';
    }
        public Object[] toArray(){
        return new Object[]{id,fecha,responsable,componente,cantidad};
    }
    
    public Object[] toArraySinId(){
        return new Object[]{id,fecha,responsable.getNombre(),componente.getNombre(),cantidad};
    }
}
