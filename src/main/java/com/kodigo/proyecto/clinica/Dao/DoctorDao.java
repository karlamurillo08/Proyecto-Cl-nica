package com.kodigo.proyecto.clinica.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kodigo.proyecto.clinica.Entity.DoctorEntity;
@Repository
public interface DoctorDao extends JpaRepository<DoctorEntity, Long> {
}
