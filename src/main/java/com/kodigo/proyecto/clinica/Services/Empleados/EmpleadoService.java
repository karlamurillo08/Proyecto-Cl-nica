package com.kodigo.proyecto.clinica.Services.Empleados;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.EmpleadoEntity;

public interface EmpleadoService {
    List<EmpleadoEntity> findAll();

    EmpleadoEntity findById(Long id);

    EmpleadoEntity createEmpleado(EmpleadoEntity empleado);

    EmpleadoEntity updateEmpleado(Long id, EmpleadoEntity empleadoDetails);

    void deleteById(Long id);

}
