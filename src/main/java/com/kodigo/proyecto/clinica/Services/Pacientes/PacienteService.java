package com.kodigo.proyecto.clinica.Services.Pacientes;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.PacienteEntity;

public interface PacienteService {
    List<PacienteEntity> findAll();

    PacienteEntity findById(Long id);

    PacienteEntity createPaciente(PacienteEntity paciente);

    PacienteEntity updatePaciente(Long id, PacienteEntity pacienteDetails);

    void deleteById(Long id);
}
