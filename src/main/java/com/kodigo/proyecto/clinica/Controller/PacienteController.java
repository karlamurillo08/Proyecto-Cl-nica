package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.PacienteEntity;
import com.kodigo.proyecto.clinica.Services.Pacientes.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<PacienteEntity> getAllPacientes() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public PacienteEntity getPacienteById(@PathVariable Long id) {
        return pacienteService.findById(id);
    }

    @PostMapping
    public PacienteEntity createPaciente(@RequestBody PacienteEntity paciente) {
        return pacienteService.createPaciente(paciente);
    }

    @PutMapping("/{id}")
    public PacienteEntity updatePaciente(@PathVariable(value = "id") Long pacienteId, @RequestBody PacienteEntity pacienteDetails) {
        return pacienteService.updatePaciente(pacienteId, pacienteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }

}
