package com.kodigo.proyecto.clinica.Controller;
import com.kodigo.proyecto.clinica.Entity.PagosEntity;
import com.kodigo.proyecto.clinica.Services.Pagos.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<PagosEntity> getAllPagos() {
        return pagoService.findAll();
    }

    @GetMapping("/{id}")
    public PagosEntity getPagoById(@PathVariable Long id) {
        return pagoService.findById(id);

    }

    @PostMapping
    public PagosEntity createPago(@RequestBody PagosEntity pago) {
        return pagoService.createPago(pago);
    }

    @PutMapping("/{id}")
    public PagosEntity updatePago(@PathVariable(value = "id") Long pagoId, @RequestBody PagosEntity pagoDetails) {
        return pagoService.updatePago(pagoId, pagoDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable(value = "id") Long pagoId) {
        pagoService.deleteById(pagoId);
    }

}
