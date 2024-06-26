package com.kodigo.proyecto.clinica.Services.Citas;
import org.springframework.stereotype.Service;
import com.kodigo.proyecto.clinica.Entity.CitasEntity;
import com.kodigo.proyecto.clinica.Dao.CitasDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CitasServiceImpl implements CitasService {
    @Autowired
    private CitasDao citasDao;

    @Override
    public List<CitasEntity> findAll() {
        return citasDao.findAll();
    }

    @Override
    public CitasEntity findById(Long id) {
        return citasDao.findById(id).orElse(null);
    }

    @Override
    public CitasEntity createCita(CitasEntity cita) {
        return citasDao.save(cita);
    }

    @Override
    public CitasEntity updateCita(Long id, CitasEntity citaDetails) {
        CitasEntity cita = citasDao.findById(id).orElseThrow();

        cita.setPaciente(citaDetails.getPaciente());
        cita.setDoctor(citaDetails.getDoctor());
        cita.setFecha(citaDetails.getFecha());
        cita.setHora(citaDetails.getHora());
        cita.setMotivo(citaDetails.getMotivo());

        return citasDao.save(cita);
    }

    @Override
    public void deleteById(Long id) {
        citasDao.deleteById(id);
    }
}
