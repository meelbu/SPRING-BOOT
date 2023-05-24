package com.example.democopia.servicio;

import com.example.democopia.dto.UsuarioRegistroDTO;
import com.example.democopia.modelo.Usuario;

public interface UsuarioServicio {

    public Usuario guardar(UsuarioRegistroDTO registroDTO);
}
