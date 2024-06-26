package com.kodigo.proyecto.clinica.Services.Especialidades;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.EspecialidadEntity;

public interface EspecialidadService {

    List<EspecialidadEntity> findAll();

    EspecialidadEntity findById(Long id);

    EspecialidadEntity createEspecialidad(EspecialidadEntity especialidad);

    EspecialidadEntity updateEspecialidad(Long id, EspecialidadEntity especialidadDetails);

    void deleteById(Long id);
}
