package com.kodigo.proyecto.clinica.Services.Medicamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.kodigo.proyecto.clinica.Entity.MedicamentoEntity;
import com.kodigo.proyecto.clinica.Dao.MedicamentoDao;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
    @Autowired
    private MedicamentoDao medicamentoDao;

    @Override
    public List<MedicamentoEntity> findAll() {
        return medicamentoDao.findAll();
    }

    @Override
    public MedicamentoEntity findById(Long id) {
        return medicamentoDao.findById(id).orElse(null);
    }

    @Override
    public MedicamentoEntity createMedicamento(MedicamentoEntity medicamento) {
        return medicamentoDao.save(medicamento);
    }

    @Override
    public MedicamentoEntity updateMedicamento(Long id, MedicamentoEntity medicamentoDetails) {
       MedicamentoEntity medicamento = medicamentoDao.findById(id).orElseThrow();

        medicamento.setNombre(medicamentoDetails.getNombre());
        medicamento.setDescripcion(medicamentoDetails.getDescripcion());
        medicamento.setPrecio(medicamentoDetails.getPrecio());

        return medicamentoDao.save(medicamento);
    }

    @Override
    public void deleteById(Long id) {
        medicamentoDao.deleteById(id);
    }
}
