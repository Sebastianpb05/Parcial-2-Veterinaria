package com.example.SistemaVeterinaria.Controller;

import com.example.SistemaVeterinaria.Model.Veterinario;
import com.example.SistemaVeterinaria.InterfaceService.IVeterinariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private IVeterinariosService veterinariosService;

    @GetMapping("/listar")
    public String listarVeterinarios(Model model) {
        List<Veterinario> veterinarios = veterinariosService.listarTodos();
        model.addAttribute("veterinarios", veterinarios);
        model.addAttribute("cuerpo", "Listado de Veterinarios");
        return "veterinarios";
    }

    @GetMapping("/nuevo")
    public String nuevoVeterinario(Model model) {
        model.addAttribute("veterinario", new Veterinario());
        return "formVeterinario";
    }

    @PostMapping("/guardar")
    public String guardarVeterinario(@ModelAttribute Veterinario veterinario) {
        veterinariosService.guardar(veterinario);
        return "redirect:/veterinarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarVeterinario(@PathVariable("id") int id, Model model) {
        model.addAttribute("veterinario", veterinariosService.obtenerPorId(id));
        return "formVeterinario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVeterinario(@PathVariable("id") int id) {
        veterinariosService.eliminar(id);
        return "redirect:/veterinarios/listar";
    }
}
