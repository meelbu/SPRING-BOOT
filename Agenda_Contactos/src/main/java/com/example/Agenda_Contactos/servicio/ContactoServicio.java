package com.example.Agenda_Contactos.servicio;

import com.example.Agenda_Contactos.entidad.Contacto;

import java.util.List;

public interface ContactoServicio {

    public List<Contacto> listarTodosLosContactos();

    public  Contacto guardarContacto(Contacto contacto);

    public Contacto obtenerContactoPorId(Integer id);

    public Contacto actualizarContacto(Contacto contacto);

    public  void Eliminar(Contacto contacto);
}
