package com.cholan.edu.prj_spring_boot_security_ii.persistence;

import com.cholan.edu.prj_spring_boot_security_ii.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
