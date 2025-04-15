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
public List<Envios> getEnvios(){
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
public void editEnvio(Long id, EnviosService envios) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'editEnvio'");
}


@Override
public EnviosService findEnvio(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findEnvio'");
}


@Override
public void deleteEnvio(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteEnvio'");
}


}
