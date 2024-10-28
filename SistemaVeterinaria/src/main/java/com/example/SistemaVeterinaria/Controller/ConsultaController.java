package com.example.SistemaVeterinaria.Controller;

import com.example.SistemaVeterinaria.InterfaceService.IConsultaService;
import com.example.SistemaVeterinaria.InterfaceService.IMascotasService;
import com.example.SistemaVeterinaria.InterfaceService.IVeterinariosService;
import com.example.SistemaVeterinaria.Model.Consulta;
import com.example.SistemaVeterinaria.Model.Mascota;
import com.example.SistemaVeterinaria.Model.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private IConsultaService consultaService;

    @Autowired
    private IMascotasService mascotaService;

    @Autowired
    private IVeterinariosService veterinarioService;

    @GetMapping("/listar")
    public String listarConsultas(Model model) {
        List<Consulta> consultas = consultaService.listarConsultas();
        model.addAttribute("consultas", consultas);
        return "consultas";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaConsulta(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("mascotas", mascotaService.listarTodos());
        model.addAttribute("veterinarios", veterinarioService.listarTodos());
        return "formConsulta";
    }

    @PostMapping("/guardar")
    public String guardarConsulta(@ModelAttribute("consulta") Consulta consulta) {
        consultaService.guardarConsulta(consulta);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarConsulta(@PathVariable int id, Model model) {
        Consulta consulta = consultaService.obtenerConsultaPorId(id);
        model.addAttribute("consulta", consulta);
        model.addAttribute("mascotas", mascotaService.listarTodos());
        model.addAttribute("veterinarios", veterinarioService.listarTodos());
        return "formConsulta";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarConsulta(@PathVariable int id) {
        consultaService.eliminarConsulta(id);
        return "redirect:/consultas/listar";
    }
}
