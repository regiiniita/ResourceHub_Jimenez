package com.example.ResourceHub.service;


import com.example.ResourceHub.model.Recurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ResourceHub.repository.RecursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> obtenerTodos(){
        return recursoRepository.findAll();
    }

    public Optional<Recurso> obtenerPorId(Long id){
        return recursoRepository.findById(id);
    }

    public Recurso crear(Recurso recurso){
        return recursoRepository.save(recurso);
    }

    public Optional<Recurso> actualizar(Long id, Recurso recurso){
        return recursoRepository.findById(id).map(recursoExists -> {
           recursoExists.setTitulo(recurso.getTitulo());
            recursoExists.setCategoria(recurso.getCategoria());
            recursoExists.setUrl(recurso.getUrl());
            recursoExists.setTipo(recurso.getTipo());
            return recursoRepository.save(recursoExists);
        });
    }

    public Optional<Recurso> actualizarParcialmente(Long id, Recurso recurso){
        return recursoRepository.findById(id).map(recursoExists -> {
            if(recurso.getTitulo()!=null){
                recursoExists.setTitulo(recurso.getTitulo());
            }
            if(recurso.getCategoria()!=null){
                recursoExists.setCategoria(recurso.getCategoria());
            }
            if(recurso.getUrl()!=null){
                recursoExists.setUrl(recurso.getUrl());
            }
            if(recurso.getTipo()!=null){
                recursoExists.setTipo(recurso.getTipo());
            }
            return recursoRepository.save(recursoExists);
        });
    }

    public boolean eliminarRecurso(Long id){
        return recursoRepository.deleteById(id);
    }
}
