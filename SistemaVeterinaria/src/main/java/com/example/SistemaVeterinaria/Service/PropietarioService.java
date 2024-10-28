package com.example.SistemaVeterinaria.Service;

import com.example.SistemaVeterinaria.Model.Propietario;
import com.example.SistemaVeterinaria.Repository.RPropietarios;
import com.example.SistemaVeterinaria.InterfaceService.IPropietariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioService implements IPropietariosService {

    @Autowired
    private RPropietarios repo;

    @Override
    public List<Propietario> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Propietario obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void guardar(Propietario propietario) {
        repo.save(propietario);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
