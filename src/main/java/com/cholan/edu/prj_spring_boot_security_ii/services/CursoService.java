package com.cholan.edu.prj_spring_boot_security_ii.services;

import com.cholan.edu.prj_spring_boot_security_ii.entities.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> listar();

    Curso guardar(Curso curso);

    void eliminar(Long id);

    Curso buscarPorId(Long id);
}
