package com.kodigo.proyecto.clinica.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Facturas")
@Getter
@Setter
@NoArgsConstructor
public class FacturasEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "total")
    private Double total;
}
