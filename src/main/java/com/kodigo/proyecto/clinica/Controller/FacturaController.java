package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.FacturasEntity;
import com.kodigo.proyecto.clinica.Services.Facturas.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<FacturasEntity> getAllFacturas() {
        return facturaService.findAll();
    }

    @GetMapping("/{id}")
    public FacturasEntity getFacturaById(@PathVariable Long id) {
        return facturaService.findById(id);

    }

    @PostMapping
    public FacturasEntity createFactura(@RequestBody FacturasEntity factura) {
        return facturaService.createFactura(factura);
    }

    @PutMapping("/{id}")
    public FacturasEntity updateFactura(@PathVariable(value = "id") Long facturaId, @RequestBody FacturasEntity facturaDetails) {
        return facturaService.updateFactura(facturaId, facturaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id) {
        facturaService.deleteById(id);

    }


}
