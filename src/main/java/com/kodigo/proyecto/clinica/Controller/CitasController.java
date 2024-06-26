package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.CitasEntity;
import com.kodigo.proyecto.clinica.Entity.DoctorEntity;
import com.kodigo.proyecto.clinica.Services.Citas.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    private CitasService citasService;

    @GetMapping()
    public List<CitasEntity> getAllCitas() {
        return citasService.findAll();
    }

    @GetMapping("/{id}")
    public CitasEntity getCitaById(@PathVariable Long id) {
       return citasService.findById(id);
    }

    @PostMapping()
    public CitasEntity createCita(@RequestBody CitasEntity cita) {
        return citasService.createCita(cita);
    }

    @PutMapping("/{id}")
    public CitasEntity updateCita(@PathVariable(value = "id") Long citaId, @RequestBody CitasEntity citaDetails) {
        return citasService.updateCita(citaId, citaDetails);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        citasService.deleteById(id);
    }
}
