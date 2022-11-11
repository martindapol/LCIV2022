/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.similtp.repositories;

import com.example.similtp.models.Recibo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Martin
 */
@Repository
@Setter
public class EmpleadoRepositoryMySql implements EmpleadoRepository {
    @Autowired
    private DataSource dataSource;

    @Override
    public void createRecibo(Recibo recibo) {
        String query;
        int rows = 0;

        query = "INSERT INTO recibos (anio, mes, monto_antig, jubilacion, obra_social, fondo_complej, legajo) VALUES (?,?, ?, ?, ?, ?, ?);";

        try ( Connection cnn = dataSource.getConnection();  PreparedStatement ps = cnn.prepareStatement(query);) {
            ps.setInt(1, recibo.getAnio());
            ps.setInt(2, recibo.getMes());
            ps.setDouble(3, recibo.getAntiguedad());
            ps.setDouble(4, recibo.getJubilacion());
            ps.setDouble(5, recibo.getObraSocial());
            ps.setDouble(6, recibo.getFondoComplejidad());
            ps.setInt(7, recibo.getEmpleado().getLegajo());
            
            rows = ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
