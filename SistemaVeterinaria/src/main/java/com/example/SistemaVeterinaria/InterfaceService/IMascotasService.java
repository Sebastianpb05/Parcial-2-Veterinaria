package com.example.SistemaVeterinaria.InterfaceService;

import com.example.SistemaVeterinaria.Model.Mascota;
import java.util.List;

public interface IMascotasService {
    List<Mascota> listarTodos();
    Mascota obtenerPorId(int id);
    void guardar(Mascota mascota);
    void eliminar(int id);
}
