package com.example.SistemaVeterinaria.Repository;

import com.example.SistemaVeterinaria.Model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RVeterinarios extends JpaRepository<Veterinario, Integer> {
}
