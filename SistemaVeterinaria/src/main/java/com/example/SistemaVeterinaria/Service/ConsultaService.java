package com.example.SistemaVeterinaria.Service;

import com.example.SistemaVeterinaria.InterfaceService.IConsultaService;
import com.example.SistemaVeterinaria.Model.Consulta;
import com.example.SistemaVeterinaria.Repository.RConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService implements IConsultaService {

    @Autowired
    private RConsultas repositorio;

    @Override
    public List<Consulta> listarConsultas() {
        return repositorio.findAll();
    }

    @Override
    public Consulta obtenerConsultaPorId(int id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Consulta guardarConsulta(Consulta consulta) {
        return repositorio.save(consulta);
    }

    @Override
    public void eliminarConsulta(int id) {
        repositorio.deleteById(id);
    }
}
