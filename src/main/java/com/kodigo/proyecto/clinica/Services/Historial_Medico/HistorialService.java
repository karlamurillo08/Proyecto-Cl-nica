package com.kodigo.proyecto.clinica.Services.Historial_Medico;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.HistorialEntity;
public interface HistorialService {
    List<HistorialEntity> findAll();

    HistorialEntity findById(Long id);

    HistorialEntity createHistorialMedico(HistorialEntity historialMedico);

    HistorialEntity updateHistorialMedico(Long id, HistorialEntity historialMedicoDetails);

    void deleteById(Long id);

}
