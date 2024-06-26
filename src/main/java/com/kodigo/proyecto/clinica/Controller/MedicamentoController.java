package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.MedicamentoEntity;
import com.kodigo.proyecto.clinica.Services.Medicamentos.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {
    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public List<MedicamentoEntity> getAllMedicamentos() {
        return medicamentoService.findAll();
    }

    @GetMapping("/{id}")
    public MedicamentoEntity getMedicamentoById(@PathVariable Long id) {
        return medicamentoService.findById(id);
    }

    @PostMapping
    public MedicamentoEntity createMedicamento(@RequestBody MedicamentoEntity medicamento) {
        return medicamentoService.createMedicamento(medicamento);
    }

    @PutMapping("/{id}")
    public MedicamentoEntity updateMedicamento(@PathVariable(value = "id") Long medicamentoId, @RequestBody MedicamentoEntity medicamentoDetails) {
       return medicamentoService.updateMedicamento(medicamentoId, medicamentoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicamento(@PathVariable Long id) {
        medicamentoService.deleteById(id);


    }



}
