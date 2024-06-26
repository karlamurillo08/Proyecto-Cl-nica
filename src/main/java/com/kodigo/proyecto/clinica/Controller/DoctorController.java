package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.DoctorEntity;
import com.kodigo.proyecto.clinica.Services.Doctores.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorEntity> getAllDoctores() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    public DoctorEntity getDoctorById(@PathVariable Long id) {
        return doctorService.findById(id);

    }

    @PostMapping()
    public DoctorEntity createDoctor(@RequestBody DoctorEntity doctor) {
        return doctorService.createDoctor(doctor);
    }

    @PutMapping("/{id}")
    public DoctorEntity updateDoctor(@PathVariable(value = "id") Long doctorId, @RequestBody DoctorEntity doctorDetails) {
        return doctorService.updateDoctor(doctorId, doctorDetails);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        doctorService.deleteById(id);

    }

}
