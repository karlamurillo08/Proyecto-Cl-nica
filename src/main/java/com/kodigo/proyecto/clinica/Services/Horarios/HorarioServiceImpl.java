package com.kodigo.proyecto.clinica.Services.Horarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.kodigo.proyecto.clinica.Entity.HorarioEntity;
import com.kodigo.proyecto.clinica.Dao.HorarioDao;

@Service
public class HorarioServiceImpl implements HorarioService {
    @Autowired
    private HorarioDao horarioDao;

    @Override
    public List<HorarioEntity> findAll() {
        return horarioDao.findAll();
    }

    @Override
    public HorarioEntity findById(Long id) {
        return horarioDao.findById(id).orElse(null);
    }

    @Override
    public HorarioEntity createHorario(HorarioEntity horario) {
        return horarioDao.save(horario);
    }

    @Override
    public HorarioEntity updateHorario(Long id, HorarioEntity horarioDetails) {
        HorarioEntity horario = horarioDao.findById(id).orElseThrow();


        horario.setEmpleado(horarioDetails.getEmpleado());
        horario.setDia(horarioDetails.getDia());
        horario.setHoraEntrada(horarioDetails.getHoraEntrada());
        horario.setHoraSalida(horarioDetails.getHoraSalida());

        return horarioDao.save(horario);
    }

    @Override
    public void deleteById(Long id) {
        horarioDao.deleteById(id);
    }

}
