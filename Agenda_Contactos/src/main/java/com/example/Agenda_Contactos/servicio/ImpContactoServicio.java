package com.example.Agenda_Contactos.servicio;

import com.example.Agenda_Contactos.entidad.Contacto;
import com.example.Agenda_Contactos.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpContactoServicio implements ContactoServicio{

    @Autowired
    private ContactoRepositorio repositorio;
    @Override
    public List<Contacto> listarTodosLosContactos() {
        return repositorio.findAll() ;
    }

    @Override
    public Contacto guardarContacto(Contacto contacto) {
        return repositorio.save(contacto);
    }

    @Override
    public Contacto obtenerContactoPorId(Integer id) {
        return repositorio.findById(id).get() ;
    }

    @Override
    public Contacto actualizarContacto(Contacto contacto) {
        return repositorio.save(contacto);
    }

    @Override
    public void Eliminar(Contacto contacto) {
        repositorio.delete(contacto);
    }
}