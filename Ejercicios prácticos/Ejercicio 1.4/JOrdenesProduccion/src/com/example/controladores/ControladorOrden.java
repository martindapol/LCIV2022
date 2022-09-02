/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controladores;

import com.example.modelo.Componente;
import com.example.modelo.OrdenProduccion;
import com.example.modelo.Responsable;

import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ControladorOrden {

    private String conexion;

    public ControladorOrden() {
        conexion = "jdbc:mysql://localhost/mydb?user=root&password=qweasd123";
        //TODO: cambiar credenciales de la conexión según sus propias bases.
    }

    public List<Responsable> obtenerResponsables() {
        List<Responsable> lst = new ArrayList<>();

        try ( Connection cnn = DriverManager.getConnection(conexion); 
                Statement stmt = cnn.createStatement();  
                ResultSet rs = stmt.executeQuery("SELECT * FROM RESPONSABLE")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                lst.add(new Responsable(id, nombre));
            }
        } catch (Exception e) {
        }

        return lst;
    }

    public List<Componente> obtenerComponenetes() {
        List<Componente> lst = new ArrayList<>();

        try ( Connection cnn = DriverManager.getConnection(conexion);  Statement stmt = cnn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM COMPONENTE")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                lst.add(new Componente(id, nombre));
            }
        } catch (Exception e) {
        }

        return lst;
    }

    public boolean registrarOrdenProduccion(OrdenProduccion orden) {

        try ( Connection cnn = DriverManager.getConnection(conexion);  
                PreparedStatement ps = cnn.prepareStatement
        ("INSERT INTO PRODUCCION (fecha, idResponsable, idComponente, cantidadProduccion) VALUES(?, ?, ?, ?)");) {
            ps.setString(1, orden.getFecha());
            ps.setInt(2, orden.getResponsable().getId());
            ps.setInt(3, orden.getComponente().getId());
            ps.setInt(4, orden.getCantidad());
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<OrdenProduccion> obtenerOrdenesResponsable(int id) {
        List<OrdenProduccion> lst = new ArrayList<>();

        try ( Connection cnn = DriverManager.getConnection(conexion);  
                Statement stmt = cnn.createStatement();  
                ResultSet rs = stmt.executeQuery(" SELECT t.*, t1.nombre as n_resp, t2.descripcion n_comp "
                + " FROM PRODUCCION t, RESPONSABLE t1, COMPONENTE t2 WHERE  "
                + " t.idresponsable = t1.id "
                + " AND t.idcomponente = t2.id "
                + " AND t1.id= " + id)) {

            while (rs.next()) {
                int idOrden = rs.getInt("id");
                String fecha = rs.getString("fecha");
                int idResponsable = rs.getInt("idresponsable");
                int idComponente = rs.getInt("idcomponente");
                int cantidad = rs.getInt("cantidadproduccion");
                String nResp = rs.getString("n_resp");
                String nComp = rs.getString("n_comp");
                Responsable resp = new Responsable(idResponsable, nResp);
                Componente comp = new Componente(idComponente, nComp);

                lst.add(new OrdenProduccion(idOrden, fecha, resp, comp, cantidad));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return lst;
    }

}
