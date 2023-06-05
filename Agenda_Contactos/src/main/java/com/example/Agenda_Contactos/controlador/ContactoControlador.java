package com.example.Agenda_Contactos.controlador;

import com.example.Agenda_Contactos.entidad.Contacto;
import com.example.Agenda_Contactos.servicio.ContactoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContactoControlador {

    @Autowired
    private ContactoServicio contactoServicio;

    @GetMapping("/")
    public String verInicio(Model model, @Param("palabraClave")String palabraClave){
        List<Contacto> contactos = contactoServicio.listarTodosLosContactos(palabraClave);

        model.addAttribute("contactos", contactos);
        model.addAttribute("palabraClave", palabraClave);

        return "resultados";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioParaRegistroDeContactos(Model model){
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    @PostMapping("/save")
    public String guardarContacto(@Validated Contacto contacto, BindingResult bindingResult,
                                  RedirectAttributes redirect, Model model){

        if (bindingResult.hasErrors()){
          model.addAttribute("contacto", contacto);
          return "nuevo";
        }

        contactoServicio.guardarContacto(contacto);
        redirect.addFlashAttribute("msgExito", "El contacto se guardó exitosamente");

        return "redirect:/";

    }

   @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Integer id, Model model){

        Contacto contacto = contactoServicio.obtenerContactoPorId(id);
        model.addAttribute("contacto", contacto);

        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizarContacto(@PathVariable Integer id, @Validated Contacto contacto,
                                     BindingResult bindingResult, RedirectAttributes redirect, Model model ){
        Contacto contactoDB = contactoServicio.obtenerContactoPorId(id);

        if (bindingResult.hasErrors()){
            model.addAttribute("contacto", contacto);

            return "editar";
        }

        contactoDB.setNombre(contacto.getNombre());
        contactoDB.setCelular(contacto.getCelular());
        contactoDB.setEmail(contacto.getEmail());
        contactoDB.setFecha_nacimiento(contacto.getFecha_nacimiento());

        contactoServicio.actualizarContacto(contactoDB);

        redirect.addFlashAttribute("msgExito", "El contacto se guardó exitosamente");

        return "redirect:/";

    }

    @PostMapping("/eliminar/{id}")
    public String eliminarContacto(@PathVariable Integer id, RedirectAttributes redirect){
        Contacto contacto = contactoServicio.obtenerContactoPorId(id);
        contactoServicio.Eliminar(contacto);

        redirect.addFlashAttribute("msgExito", "El contacto se eliminó correctamente");

        return "redirect:/";
    }

}
