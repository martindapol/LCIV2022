/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example;

import com.example.controllers.ControladorServicio;
import com.example.views.JFPrincipal;

/**
 *
 * @author Martin
 */
public class Ejecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            new JFPrincipal(new ControladorServicio()).setVisible(true);
        } catch (Exception ex) {
            // handle the error driver
        }
    }

}
