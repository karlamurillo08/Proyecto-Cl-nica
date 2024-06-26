package com.kodigo.proyecto.clinica.Services.Facturas;
import org.springframework.stereotype.Service;
import com.kodigo.proyecto.clinica.Entity.FacturasEntity;
import com.kodigo.proyecto.clinica.Dao.FacturaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaDao facturaDao;

    @Override
    public List<FacturasEntity> findAll() {
        return facturaDao.findAll();
    }

    @Override
    public FacturasEntity findById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    public FacturasEntity createFactura(FacturasEntity factura) {
        return facturaDao.save(factura);
    }

    @Override
    public FacturasEntity updateFactura(Long id, FacturasEntity facturaDetails) {
        FacturasEntity factura = facturaDao.findById(id).orElseThrow();

        factura.setPaciente(facturaDetails.getPaciente());
        factura.setFecha(facturaDetails.getFecha());
        factura.setTotal(facturaDetails.getTotal());

        return facturaDao.save(factura);
    }

    @Override
    public void deleteById(Long id) {
        facturaDao.deleteById(id);
    }

}
