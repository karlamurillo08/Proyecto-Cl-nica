package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.EmpleadoEntity;
import com.kodigo.proyecto.clinica.Services.Empleados.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<EmpleadoEntity> getAllEmpleados() {
        return empleadoService.findAll();
    }

    @GetMapping("/{id}")
    public EmpleadoEntity getEmpleadoById(@PathVariable Long id) {
        return empleadoService.findById(id);
    }

    @PostMapping
    public EmpleadoEntity createEmpleado(@RequestBody EmpleadoEntity empleado) {
        return empleadoService.createEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public EmpleadoEntity updateEmpleado(@PathVariable(value = "id") Long empleadoId, @RequestBody EmpleadoEntity empleadoDetails) {
        return empleadoService.updateEmpleado(empleadoId, empleadoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteById(id);

    }
}
