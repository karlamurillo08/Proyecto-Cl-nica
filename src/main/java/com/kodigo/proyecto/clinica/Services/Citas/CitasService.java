package com.kodigo.proyecto.clinica.Services.Citas;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.CitasEntity;
public interface CitasService {
    List<CitasEntity> findAll();

    CitasEntity findById(Long id);

    CitasEntity createCita(CitasEntity cita);

    CitasEntity updateCita(Long id, CitasEntity citaDetails);

    void deleteById(Long id);
}
