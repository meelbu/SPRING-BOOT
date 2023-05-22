package com.example.Agenda_Contactos.repositorio;

import com.example.Agenda_Contactos.entidad.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {
}
