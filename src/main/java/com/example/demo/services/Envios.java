package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

public interface Envios {

    public List<Envios> getEnvios();

    public void saveEnvio(LocalDate fecha, String estadoProcesamiento, String procesamiento );

    public void editEnvio(Long id, Envios envios);

    public Envios findEnvio(Long id);

    public void deleteEnvio(Long id);
}
