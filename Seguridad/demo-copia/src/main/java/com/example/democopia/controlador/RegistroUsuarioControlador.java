package com.example.democopia.controlador;

import com.example.democopia.dto.UsuarioRegistroDTO;
import com.example.democopia.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){
        return  new UsuarioRegistroDTO();
    }

    @GetMapping
    public String MostrarFormularioDeRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario")
                                           UsuarioRegistroDTO registroDTO){

        usuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }

}
