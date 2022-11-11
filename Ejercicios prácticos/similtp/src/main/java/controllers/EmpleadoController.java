/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.example.similtp.dtos.ReciboDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    
    @PostMapping("/recibos/nuevo")
    public ResponseEntity<?> registrarRecibo(@RequestBody ReciboDTO reciboDto){
        //convertir reciboDto -> recibo
        //llamar al repositorio(recibo)
        //retornar un OK (200)
        return null;
    }
}
