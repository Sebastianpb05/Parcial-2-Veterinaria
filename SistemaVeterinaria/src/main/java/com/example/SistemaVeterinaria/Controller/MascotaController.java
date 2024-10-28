package com.example.SistemaVeterinaria.Controller;

import com.example.SistemaVeterinaria.Model.Mascota;
import com.example.SistemaVeterinaria.Model.Propietario;
import com.example.SistemaVeterinaria.InterfaceService.IMascotasService;
import com.example.SistemaVeterinaria.InterfaceService.IPropietariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private IMascotasService mascotasService;

    @Autowired
    private IPropietariosService propietariosService;

    // Listar mascotas
    @GetMapping("/listar")
    public String listarMascotas(Model model) {
        List<Mascota> mascotas = mascotasService.listarTodos();
        model.addAttribute("mascotas", mascotas);
        model.addAttribute("cuerpo", "Listado de Mascotas");
        return "mascotas";
    }

    // Nuevo mascota
    @GetMapping("/nuevo")
    public String nuevaMascota(Model model) {
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("propietarios", propietariosService.listarTodos());
        return "formMascota";
    }

    // Guardar nueva mascota o actualización
    @PostMapping("/guardar")
    public String guardarMascota(@ModelAttribute Mascota mascota) {
        mascotasService.guardar(mascota);
        return "redirect:/mascotas/listar";
    }

    // Editar mascota
    @GetMapping("/editar/{id}")
    public String editarMascota(@PathVariable("id") int id, Model model) {
        model.addAttribute("mascota", mascotasService.obtenerPorId(id));
        model.addAttribute("propietarios", propietariosService.listarTodos());
        return "formMascota";
    }

    // Eliminar mascota
    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") int id) {
        mascotasService.eliminar(id);
        return "redirect:/mascotas/listar";
    }
}
