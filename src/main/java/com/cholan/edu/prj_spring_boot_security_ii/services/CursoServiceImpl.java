package com.cholan.edu.prj_spring_boot_security_ii.services;

import com.cholan.edu.prj_spring_boot_security_ii.entities.Curso;
import com.cholan.edu.prj_spring_boot_security_ii.persistence.CursoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoDao cursoDao;

    public CursoServiceImpl(CursoDao cursoDao) {
        this.cursoDao = cursoDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listar() {
        return cursoDao.findAll();
    }

    @Override
    @Transactional
    public Curso guardar(Curso curso) {
        return cursoDao.save(curso);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        cursoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Curso buscarPorId(Long id) {
        return cursoDao.findById(id).orElse(null);
    }
}
