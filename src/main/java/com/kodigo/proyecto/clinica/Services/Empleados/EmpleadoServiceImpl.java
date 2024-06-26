package com.kodigo.proyecto.clinica.Services.Empleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.kodigo.proyecto.clinica.Entity.EmpleadoEntity;
import com.kodigo.proyecto.clinica.Dao.EmpleadoDao;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoDao empleadoDao;

    @Override
    public List<EmpleadoEntity> findAll() {
        return empleadoDao.findAll();
    }

    @Override
    public EmpleadoEntity findById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public EmpleadoEntity createEmpleado(EmpleadoEntity empleado) {
        return empleadoDao.save(empleado);
    }

    @Override
    public EmpleadoEntity updateEmpleado(Long id, EmpleadoEntity empleadoDetails) {
        EmpleadoEntity empleado = empleadoDao.findById(id).orElse(null);

        assert empleado != null;
        empleado.setNombre(empleadoDetails.getNombre());
        empleado.setApellido(empleadoDetails.getApellido());
        empleado.setPuesto(empleadoDetails.getPuesto());
        empleado.setTelefono(empleadoDetails.getTelefono());
        empleado.setSalario(empleadoDetails.getSalario());

        return empleadoDao.save(empleado);
    }

    @Override
    public void deleteById(Long id) {
        empleadoDao.deleteById(id);
    }


}
