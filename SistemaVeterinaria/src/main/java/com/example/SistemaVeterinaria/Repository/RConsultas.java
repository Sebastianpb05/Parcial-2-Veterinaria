package com.example.SistemaVeterinaria.Repository;

import com.example.SistemaVeterinaria.Model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RConsultas extends JpaRepository<Consulta, Integer> {
}