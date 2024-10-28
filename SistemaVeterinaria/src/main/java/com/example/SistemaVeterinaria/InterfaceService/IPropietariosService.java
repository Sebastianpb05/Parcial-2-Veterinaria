package com.example.SistemaVeterinaria.InterfaceService;

import com.example.SistemaVeterinaria.Model.Propietario;
import java.util.List;

public interface IPropietariosService {
    List<Propietario> listarTodos();
    Propietario obtenerPorId(int id);
    void guardar(Propietario propietario);
    void eliminar(int id);
}
