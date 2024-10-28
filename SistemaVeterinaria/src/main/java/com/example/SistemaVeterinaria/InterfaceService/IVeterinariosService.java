package com.example.SistemaVeterinaria.InterfaceService;

import com.example.SistemaVeterinaria.Model.Veterinario;
import java.util.List;

public interface IVeterinariosService {
    List<Veterinario> listarTodos();
    Veterinario obtenerPorId(int id);
    void guardar(Veterinario veterinario);
    void eliminar(int id);
}
