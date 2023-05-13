package com.example.Registro_Estudiantes.controlador;

import com.example.Registro_Estudiantes.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;

    @GetMapping("/")
    public String listarEstudiantes(Model model){

        model.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
        return "estudiantes";
    }

}
