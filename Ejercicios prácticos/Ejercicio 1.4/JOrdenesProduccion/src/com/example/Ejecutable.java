
package com.example;

import com.example.vista.JFMenuPrincipal;
import java.util.List;


public class Ejecutable {


    public static void main(String[] args) {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             //TODO: Crear y mostrar Pantalla Menú desde aquí:
             new JFMenuPrincipal().setVisible(true);
        } catch (Exception ex) {
            // handle the error
        }
    }
    
}
