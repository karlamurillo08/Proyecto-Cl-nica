package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.HistorialEntity;
import com.kodigo.proyecto.clinica.Services.Historial_Medico.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistoralController {

    @Autowired
    private HistorialService historialService;

    @GetMapping
    public List<HistorialEntity> getAllHistorialMedico() {
        return historialService.findAll();
    }

    @GetMapping("/{id}")
    public HistorialEntity getHistorialMedicoById(@PathVariable Long id) {
        return historialService.findById(id);
    }

    @PostMapping()
    public HistorialEntity createHistorialMedico(@RequestBody HistorialEntity historialMedico) {
        return historialService.createHistorialMedico(historialMedico);
    }

    @PutMapping("/{id}")
    public HistorialEntity updateHistorialMedico(@PathVariable(value = "id") Long historialMedicoId, @RequestBody HistorialEntity historialMedicoDetails) {
        return historialService.updateHistorialMedico(historialMedicoId, historialMedicoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteHistorialMedico(@PathVariable Long id) {
        historialService.deleteById(id);

    }
}
