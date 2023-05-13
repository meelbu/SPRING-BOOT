package com.example.Registro_Estudiantes.repositorio;

import com.example.Registro_Estudiantes.entidad.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {


}
