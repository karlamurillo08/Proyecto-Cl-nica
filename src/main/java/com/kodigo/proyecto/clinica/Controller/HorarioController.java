package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.HorarioEntity;
import com.kodigo.proyecto.clinica.Services.Horarios.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public List<HorarioEntity> getAllHorarios() {
        return horarioService.findAll();
    }

    @GetMapping("/{id}")
    public HorarioEntity getHorarioById(@PathVariable Long id) {
        return horarioService.findById(id);
    }

    @PostMapping
    public HorarioEntity createHorario(@RequestBody HorarioEntity horario) {
        return horarioService.createHorario(horario);
    }

    @PutMapping("/{id}")
    public HorarioEntity updateHorario(@PathVariable(value = "id") Long horarioId, @RequestBody HorarioEntity horarioDetails) {
        return horarioService.updateHorario(horarioId, horarioDetails);
    }

    @DeleteMapping("{id}")
    public void deleteHorario(@PathVariable Long id) {
        horarioService.deleteById(id);

    }
}
