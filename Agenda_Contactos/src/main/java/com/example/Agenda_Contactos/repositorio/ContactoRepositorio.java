package com.example.Agenda_Contactos.repositorio;

import com.example.Agenda_Contactos.entidad.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {

    @Query("SELECT c FROM Contacto c WHERE"
    + " CONCAT(c.id,c.nombre, c.email, c.celular, c.fecha_nacimiento, c.fecha_registro)"
    + " LIKE %?1%")
    public List<Contacto> findAll(String palabraClave);
}
