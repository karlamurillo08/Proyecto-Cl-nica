package com.kodigo.proyecto.clinica.Dao;
import com.sun.jdi.LongValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kodigo.proyecto.clinica.Entity.FacturasEntity;
@Repository
public interface FacturaDao extends JpaRepository<FacturasEntity, Long>{
}
