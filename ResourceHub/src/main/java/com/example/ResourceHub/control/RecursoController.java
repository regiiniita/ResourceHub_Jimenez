package com.example.ResourceHub.control;

import com.example.ResourceHub.model.Recurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ResourceHub.service.RecursoService;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> lista(){
        return recursoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Recurso listarPorId(@PathVariable Long id){
        return recursoService.obtenerPorId(id).orElse(null);
    }

    @PostMapping()
    public Recurso crear(@RequestBody Recurso recurso){
        return recursoService.crear(recurso);
    }

    @PutMapping("/{id}")
    public Recurso actualizar(@PathVariable Long id,@RequestBody Recurso recurso){
        return recursoService.actualizar(id,recurso).orElse(null);
    }

    @PatchMapping("/{id}")
    public Recurso actualizarParcial(@PathVariable Long id,@RequestBody Recurso recurso){
        return recursoService.actualizar(id,recurso).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        recursoService.eliminarRecurso(id);
    }
}
