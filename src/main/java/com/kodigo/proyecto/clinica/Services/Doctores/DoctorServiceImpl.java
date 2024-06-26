package com.kodigo.proyecto.clinica.Services.Doctores;
import org.springframework.stereotype.Service;
import com.kodigo.proyecto.clinica.Entity.DoctorEntity;
import com.kodigo.proyecto.clinica.Dao.DoctorDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public List<DoctorEntity> findAll() {
        return doctorDao.findAll();
    }

    @Override
    public DoctorEntity findById(Long id) {
        return doctorDao.findById(id).orElse(null);
    }

    @Override
    public DoctorEntity createDoctor(DoctorEntity doctor) {
        return doctorDao.save(doctor);
    }

    @Override
    public DoctorEntity updateDoctor(Long id, DoctorEntity doctorDetails) {
        DoctorEntity doctor = doctorDao.findById(id).orElseThrow();

        doctor.setNombre(doctorDetails.getNombre());
        doctor.setApellido(doctorDetails.getApellido());
        doctor.setEspecialidad(doctorDetails.getEspecialidad());
        doctor.setTelefono(doctorDetails.getTelefono());

        return doctorDao.save(doctor);
    }

    @Override
    public void deleteById(Long id) {
        doctorDao.deleteById(id);
    }
}
