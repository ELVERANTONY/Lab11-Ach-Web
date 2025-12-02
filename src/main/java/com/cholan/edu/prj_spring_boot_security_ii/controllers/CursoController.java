package com.cholan.edu.prj_spring_boot_security_ii.controllers;

import com.cholan.edu.prj_spring_boot_security_ii.entities.Curso;
import com.cholan.edu.prj_spring_boot_security_ii.services.CursoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/list")
    public String listar(Model model) {
        model.addAttribute("cursos", cursoService.listar());
        return "list";
    }

    @GetMapping("/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String nuevo(Model model) {
        model.addAttribute("curso", new Curso());
        return "form";
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String guardar(@ModelAttribute Curso curso) {
        cursoService.guardar(curso);
        return "redirect:/cursos/list";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("curso", cursoService.buscarPorId(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return "redirect:/cursos/list";
    }
}
