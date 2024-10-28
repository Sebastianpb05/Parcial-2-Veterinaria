package com.example.SistemaVeterinaria.Repository;

import com.example.SistemaVeterinaria.Model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPropietarios extends JpaRepository<Propietario, Integer> {
}
