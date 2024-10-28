package com.example.SistemaVeterinaria.Service;

import com.example.SistemaVeterinaria.Model.Veterinario;
import com.example.SistemaVeterinaria.Repository.RVeterinarios;
import com.example.SistemaVeterinaria.InterfaceService.IVeterinariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService implements IVeterinariosService {

    @Autowired
    private RVeterinarios repo;

    @Override
    public List<Veterinario> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Veterinario obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void guardar(Veterinario veterinario) {
        repo.save(veterinario);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
