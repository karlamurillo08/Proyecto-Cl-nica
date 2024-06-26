package com.kodigo.proyecto.clinica.Services.Especialidades;
import org.springframework.stereotype.Service;
import com.kodigo.proyecto.clinica.Entity.EspecialidadEntity;
import com.kodigo.proyecto.clinica.Dao.EspecialidadDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadDao especialidadDao;


    @Override
    public List<EspecialidadEntity> findAll() {
        return especialidadDao.findAll();
    }

    @Override
    public EspecialidadEntity findById(Long id) {
        return especialidadDao.findById(id).orElse(null);
    }

    @Override
    public EspecialidadEntity createEspecialidad(EspecialidadEntity especialidad) {
        return especialidadDao.save(especialidad);
    }

    @Override
    public EspecialidadEntity updateEspecialidad(Long id, EspecialidadEntity especialidadDetails) {
        EspecialidadEntity especialidad = especialidadDao.findById(id).orElseThrow();

        especialidad.setNombre(especialidadDetails.getNombre());

        return especialidadDao.save(especialidad);
    }

    @Override
    public void deleteById(Long id) {
        especialidadDao.deleteById(id);
    }
}
