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
@Table(name = "Pagos")
@Getter
@Setter
@NoArgsConstructor
public class PagosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private FacturasEntity factura;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "monto")
    private Double monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private MetodoPago metodoPago;

    // Enum for MetodoPago
    public enum MetodoPago {
        Efectivo,
        Tarjeta,
        Transferencia
    }



}
