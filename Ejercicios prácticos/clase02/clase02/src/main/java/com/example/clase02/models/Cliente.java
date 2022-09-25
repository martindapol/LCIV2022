/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.clase02.models;

/**
 *
 * @author Martin
 */
public class Cliente {
    private int codigo;
    private String nombre;
    private float saldo;
    private int tipo;

    public Cliente(int codigo, String nombre, float saldo, int tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "COD: " + codigo + "| Nombre: " + nombre + " |Saldo: " + saldo;
    }
    
    
    
}
