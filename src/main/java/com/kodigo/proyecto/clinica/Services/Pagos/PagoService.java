package com.kodigo.proyecto.clinica.Services.Pagos;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.PagosEntity;
public interface PagoService {
    List<PagosEntity> findAll();

    PagosEntity findById(Long id);

    PagosEntity createPago(PagosEntity pago);

    PagosEntity updatePago(Long id, PagosEntity pagoDetails);

    void deleteById(Long id);
}


