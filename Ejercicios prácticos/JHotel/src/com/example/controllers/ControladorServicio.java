/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controllers;

import com.example.model.Dtos.ConsumoDTO;
import com.example.model.Habitacion;
import com.example.model.Servicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class ControladorServicio {

    private String conexion;

    public ControladorServicio() {
        conexion = "jdbc:mysql://localhost/hoteles?user=root&password=root9718";
        //TODO: cambiar credenciales de la conexión según sus propias bases.
    }

    public List<Habitacion> obtenerHabitaciones() {
        List<Habitacion> lst = new ArrayList<>();

        try ( Connection cnn = DriverManager.getConnection(conexion);  Statement stmt = cnn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM HABITACIONES")) {

            while (rs.next()) {
                int id = rs.getInt("idHabitacion");
                String nombre = rs.getString("Denominacion");
                lst.add(new Habitacion(id, nombre));
            }
        } catch (Exception e) {
        }

        return lst;
    }

    public boolean registrarServicio(Servicio servicio) {
        boolean ok = true;

        try ( Connection cnn = DriverManager.getConnection(conexion);  PreparedStatement ps = cnn.prepareStatement("INSERT INTO Servicios (concepto, idHabitacion,importe) VALUES( ?, ?, ?)");) {
            ps.setString(1, servicio.getConcepto());
            ps.setInt(2, servicio.getHabitacion().getNroHabitacion());
            ps.setFloat(3, servicio.getPrecio());

            ok = ps.execute();
        } catch (Exception e) {
            ok = false;
        }

        return ok;

    }

    
     public List<ConsumoDTO> obtenerReporte2() {
        List<ConsumoDTO> lst = new ArrayList<>();

        String query = "SELECT t.idHabitacion, t.denominacion, sum(t2.importe) as total, count(t2.IdServicio) as cantidad "
                + "FROM habitaciones t, servicios t2 "
                + "WHERE t.idHabitacion = t2.idHabitacion "
                + "group by t.idHabitacion, t.denominacion "
                + "Having count(t2.IdServicio)  > 3";
        
        
         try ( Connection cnn = DriverManager.getConnection(conexion);  Statement stmt = cnn.createStatement();  ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("idHabitacion");
                String nombre = rs.getString("Denominacion");
                float total = rs.getFloat("total");
                int cantidad = rs.getInt("cantidad");
                
                lst.add(new ConsumoDTO(id, nombre, total, cantidad));
            }
        } catch (Exception e) {
        }
        return lst;
    }

    
    
    public float obtenerReporte1() {
        String query = "SELECT SUM(t.importe) as total FROM Servicios t";
        float total = 0;
         try ( Connection cnn = DriverManager.getConnection(conexion);  Statement stmt = cnn.createStatement();  ResultSet rs = stmt.executeQuery(query)) {
            if(rs.next()) {
                total = rs.getFloat("total");
            }
        } catch (Exception e) {
        }
        return total;
    }

    public List<Servicio> obtenerReporte3(int idHabitacion) {
        List<Servicio> lst = new ArrayList<>();
        String query = "SELECT * FROM Servicios t WHERE idHabitacion = " + idHabitacion;
         try ( Connection cnn = DriverManager.getConnection(conexion);  Statement stmt = cnn.createStatement();  ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()) {
                int id = rs.getInt("idServicio");
                String concepto = rs.getString("concepto");
                float importe = rs.getFloat("importe");
                lst.add(new Servicio(id, concepto,importe, null)); //No necesitamos recuperar los datos de la habitación
            }
        } catch (Exception e) {
        }
        return lst;
    }

}
