package com.kodigo.proyecto.clinica.Services.Doctores;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.DoctorEntity;

public interface DoctorService {
    List<DoctorEntity> findAll();

    DoctorEntity findById(Long id);

    DoctorEntity createDoctor(DoctorEntity doctor);

    DoctorEntity updateDoctor(Long id, DoctorEntity doctorDetails);

    void deleteById(Long id);


}
