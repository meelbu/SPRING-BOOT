package com.example.democopia.servicio;

import com.example.democopia.dto.UsuarioRegistroDTO;
import com.example.democopia.modelo.Rol;
import com.example.democopia.modelo.Usuario;
import com.example.democopia.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {

        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(), registroDTO.getEmail(),
                registroDTO.getPassword(), Arrays.asList(new Rol("ROLE_USER")));

        return repositorio.save(usuario);
    }
}
