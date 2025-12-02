package com.cholan.edu.prj_spring_boot_security_ii.persistence;

import com.cholan.edu.prj_spring_boot_security_ii.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoDao extends JpaRepository<Curso, Long> {
}
