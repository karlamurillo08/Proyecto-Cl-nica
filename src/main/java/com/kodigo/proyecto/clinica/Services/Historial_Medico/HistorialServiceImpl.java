package com.kodigo.proyecto.clinica.Services.Historial_Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.kodigo.proyecto.clinica.Entity.HistorialEntity;
import com.kodigo.proyecto.clinica.Dao.HistorialDao;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    private HistorialDao historialDao;

    @Override
    public List<HistorialEntity> findAll() {
        return historialDao.findAll();
    }

    @Override
    public HistorialEntity findById(Long id) {
        return historialDao.findById(id).orElse(null);
    }

    @Override
    public HistorialEntity createHistorialMedico(HistorialEntity historialMedico) {
        return historialDao.save(historialMedico);
    }

    @Override
    public HistorialEntity updateHistorialMedico(Long id, HistorialEntity historialMedicoDetails) {
        HistorialEntity historialMedico = historialDao.findById(id).orElseThrow();

        historialMedico.setPaciente(historialMedicoDetails.getPaciente());
        historialMedico.setDoctor(historialMedicoDetails.getDoctor());
        historialMedico.setFecha(historialMedicoDetails.getFecha());
        historialMedico.setDiagnostico(historialMedicoDetails.getDiagnostico());
        historialMedico.setTratamiento(historialMedicoDetails.getTratamiento());

        return historialDao.save(historialMedico);
    }

    @Override
    public void deleteById(Long id) {
        historialDao.deleteById(id);
    }
}
