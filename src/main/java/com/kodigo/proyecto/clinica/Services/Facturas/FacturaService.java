package com.kodigo.proyecto.clinica.Services.Facturas;
import java.util.List;
import com.kodigo.proyecto.clinica.Entity.FacturasEntity;
public interface FacturaService {
    List<FacturasEntity> findAll();

    FacturasEntity findById(Long id);

    FacturasEntity createFactura(FacturasEntity factura);

    FacturasEntity updateFactura(Long id, FacturasEntity facturaDetails);

    void deleteById(Long id);
}
