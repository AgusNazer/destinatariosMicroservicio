package com.example.demo.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Envios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnvio;

    @CreatedDate
    private LocalDateTime fechaCreacion;
    private String estadoProcesamiento;
    private String description;

    private Long idClienteDestinatario;
}
