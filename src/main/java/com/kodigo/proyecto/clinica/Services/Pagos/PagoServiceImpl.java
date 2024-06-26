package com.kodigo.proyecto.clinica.Services.Pagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.kodigo.proyecto.clinica.Entity.PagosEntity;
import com.kodigo.proyecto.clinica.Dao.PagoDao;

@Service
public class PagoServiceImpl implements PagoService {
    @Autowired
    private PagoDao pagoDao;

    @Override
    public List<PagosEntity> findAll() {
        return pagoDao.findAll();
    }

    @Override
    public PagosEntity findById(Long id) {
        return pagoDao.findById(id).orElse(null);
    }

    @Override
    public PagosEntity createPago(PagosEntity pago) {
        return pagoDao.save(pago);
    }

    @Override
    public PagosEntity updatePago(Long id, PagosEntity pagoDetails) {
        PagosEntity pago = pagoDao.findById(id).orElseThrow();
        pago.setFactura(pagoDetails.getFactura());
        pago.setFecha(pagoDetails.getFecha());
        pago.setMonto(pagoDetails.getMonto());
        pago.setMetodoPago(pagoDetails.getMetodoPago());

        return pagoDao.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        pagoDao.deleteById(id);
    }
}
