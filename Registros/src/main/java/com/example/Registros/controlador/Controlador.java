package com.example.Registros.controlador;

import com.example.Registros.entidad.Persona;
import com.example.Registros.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Controlador {

    @Autowired
    private PersonaServicio servicio;

    @GetMapping("/")
    public String home(){
        return "home";
    }


    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas = servicio.listarTodasLasPersonas();

        model.addAttribute("personas", personas);

        return "index";
    }

    @GetMapping("/new")
    public String Agregar(Model model){
        Persona persona = new Persona();

        model.addAttribute("persona", persona);

        return "crear_persona";
    }

    @PostMapping("/save")
    public String Guardar(@ModelAttribute("persona") Persona persona){
        servicio.guardarPersona(persona);

        return "redirect:/listar";

    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Integer id, Model model){

        model.addAttribute("persona", servicio.obtenerPersonaPorId(id));

        return "editar_persona";
    }

    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Integer id, @ModelAttribute("persona")Persona persona){

        Persona personaExistente = servicio.obtenerPersonaPorId(id);

        personaExistente.setId(id);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setTelefono(persona.getTelefono());

        servicio.actualizarPersona(persona);

        return "redirect:/listar";

    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Integer id){
        servicio.eliminarPersona(id);

        return "redirect:/listar";
    }

}
