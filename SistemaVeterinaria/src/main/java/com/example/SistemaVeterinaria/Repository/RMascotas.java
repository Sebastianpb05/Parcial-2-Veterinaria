package com.example.SistemaVeterinaria.Repository;

import com.example.SistemaVeterinaria.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RMascotas extends JpaRepository<Mascota, Integer> {
}
