package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.EspecialidadEntity;
import com.kodigo.proyecto.clinica.Services.Especialidades.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public List<EspecialidadEntity> getAllEspecialidades() {
        return especialidadService.findAll();
    }

    @GetMapping("/{id}")
    public EspecialidadEntity findById(@PathVariable Long id) {
        return especialidadService.findById(id);

    }

    @PostMapping()
    public EspecialidadEntity createEspecialidad(@RequestBody EspecialidadEntity especialidad) {
        return especialidadService.createEspecialidad(especialidad);
    }

    @PutMapping("/{id}")
    public EspecialidadEntity updateEspecialidad(@PathVariable(value = "id") Long especialidadId, @RequestBody EspecialidadEntity especialidadDetails) {
        return especialidadService.updateEspecialidad(especialidadId, especialidadDetails);

    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        especialidadService.deleteById(id);
    }
}
