package com.example.Registro_Estudiantes.servicio;

import com.example.Registro_Estudiantes.entidad.Estudiante;

import java.util.List;

public interface EstudianteServicio {

    public List<Estudiante> listarTodosLosEstudiantes();

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public Estudiante obtenerPorId(long id);

    public Estudiante actualizarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(long id);

}
