package com.kodigo.proyecto.clinica.Services.Medicamentos;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.MedicamentoEntity;

public interface MedicamentoService {
    List<MedicamentoEntity> findAll();

    MedicamentoEntity findById(Long id);

    MedicamentoEntity createMedicamento(MedicamentoEntity medicamento);

    MedicamentoEntity updateMedicamento(Long id, MedicamentoEntity medicamentoDetails);

    void deleteById(Long id);
}
