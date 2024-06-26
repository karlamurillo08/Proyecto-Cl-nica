package com.kodigo.proyecto.clinica.Services.Horarios;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.HorarioEntity;
import com.kodigo.proyecto.clinica.Entity.PacienteEntity;

public interface HorarioService {
    List<HorarioEntity> findAll();

    HorarioEntity findById(Long id);

    HorarioEntity createHorario(HorarioEntity horario);

    HorarioEntity updateHorario(Long id, HorarioEntity horarioDetails);

    void deleteById(Long id);

}
