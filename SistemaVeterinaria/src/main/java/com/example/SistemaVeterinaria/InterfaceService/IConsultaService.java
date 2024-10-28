package com.example.SistemaVeterinaria.InterfaceService;

import com.example.SistemaVeterinaria.Model.Consulta;
import java.util.List;

public interface IConsultaService {
    List<Consulta> listarConsultas();
    Consulta guardarConsulta(Consulta consulta);
    Consulta obtenerConsultaPorId(int id);
    void eliminarConsulta(int id);
}
