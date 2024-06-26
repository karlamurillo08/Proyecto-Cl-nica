package com.kodigo.proyecto.clinica.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kodigo.proyecto.clinica.Entity.PacienteEntity;

@Repository
public interface PacienteDao extends JpaRepository<PacienteEntity, Long>{

}
