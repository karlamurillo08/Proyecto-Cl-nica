package com.kodigo.proyecto.clinica.Services.Pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.kodigo.proyecto.clinica.Entity.PacienteEntity;
import com.kodigo.proyecto.clinica.Dao.PacienteDao;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteDao pacienteDao;

    @Override
    public List<PacienteEntity> findAll() {
        return pacienteDao.findAll();
    }

    @Override
    public PacienteEntity findById(Long id) {
        return pacienteDao.findById(id).orElse(null);
    }

    @Override
    public PacienteEntity createPaciente(PacienteEntity paciente) {
        return pacienteDao.save(paciente);
    }

    @Override
    public PacienteEntity updatePaciente(Long id, PacienteEntity pacienteDetails) {
        PacienteEntity paciente = pacienteDao.findById(id).orElseThrow();

        paciente.setNombre(pacienteDetails.getNombre());
        paciente.setApellido(pacienteDetails.getApellido());
        paciente.setFechaNacimiento(pacienteDetails.getFechaNacimiento());
        paciente.setGenero(pacienteDetails.getGenero());
        paciente.setDireccion(pacienteDetails.getDireccion());
        paciente.setTelefono(pacienteDetails.getTelefono());

        return pacienteDao.save(paciente);
    }

    @Override
    public void deleteById(Long id) {
        pacienteDao.deleteById(id);
    }

}
