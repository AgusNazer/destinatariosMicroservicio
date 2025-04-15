package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Envios;
import com.example.demo.repository.IEnviosRepository;

@Service
public class IEnviosService implements EnviosService {

    @Autowired
    private IEnviosRepository enviosRepository;

    @Override
    public List<Envios> getEnvios() {
        return enviosRepository.findAll();
    }

    @Override
    public void saveEnvio(LocalDate fechaCreacion, String estadoProcesamiento, String description) {
        Envios envio = new Envios();
        envio.setFechaCreacion(fechaCreacion.atStartOfDay()); // 👈 convierte a LocalDateTime
        envio.setEstadoProcesamiento(estadoProcesamiento);
        envio.setDescription(description);
        enviosRepository.save(envio);
    }

    @Override
    public void editEnvio(Long id, Envios envios, String estadoProcesamiento) {
        Envios envio = findEnvio(id); // este es el que vas a modificar y guardar
    
        envio.setDescription(envios.getDescription());
        envio.setEstadoProcesamiento(estadoProcesamiento);
    
        enviosRepository.save(envio);
    }

    @Override
    public Envios findEnvio(Long id) {
        return enviosRepository.findById(id).orElseThrow(() ->
        new RuntimeException("No se encontró el envío con ID: " + id));
    }

    @Override
    public void deleteEnvio(Long id) {
        enviosRepository.deleteById(id);
    }

}
