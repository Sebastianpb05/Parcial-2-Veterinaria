package com.example.SistemaVeterinaria.Service;

import com.example.SistemaVeterinaria.Model.Mascota;
import com.example.SistemaVeterinaria.Repository.RMascotas;
import com.example.SistemaVeterinaria.InterfaceService.IMascotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotasService {

    @Autowired
    private RMascotas repo;

    @Override
    public List<Mascota> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Mascota obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void guardar(Mascota mascota) {
        repo.save(mascota);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
