/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.similtp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReciboDTO {
    private int mes;
    private int anio;
    private double antiguedad;
    private double jubilacion;
    private double obraSocial;
    private double fondoComplejidad;
    private int legajo;
}
