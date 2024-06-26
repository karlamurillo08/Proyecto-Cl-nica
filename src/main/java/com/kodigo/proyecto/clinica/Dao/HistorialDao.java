package com.kodigo.proyecto.clinica.Dao;
import com.kodigo.proyecto.clinica.Entity.HistorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HistorialDao extends JpaRepository<HistorialEntity, Long>{
}
