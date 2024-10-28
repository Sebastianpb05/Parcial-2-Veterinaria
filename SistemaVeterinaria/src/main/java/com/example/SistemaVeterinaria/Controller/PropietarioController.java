package com.example.SistemaVeterinaria.Controller;

import com.example.SistemaVeterinaria.Model.Propietario;
import com.example.SistemaVeterinaria.InterfaceService.IPropietariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private IPropietariosService propietariosService;

    @GetMapping("/listar")
    public String listarPropietarios(Model model) {
        List<Propietario> propietarios = propietariosService.listarTodos();
        model.addAttribute("propietarios", propietarios);
        model.addAttribute("cuerpo", "Listado de Propietarios");
        return "propietarios";
    }

    @GetMapping("/nuevo")
    public String nuevoPropietario(Model model) {
        model.addAttribute("propietario", new Propietario());
        return "formPropietario";
    }

    @PostMapping("/guardar")
    public String guardarPropietario(@ModelAttribute Propietario propietario) {
        if (propietario.getId() != 0) {
            Propietario propietarioExistente = propietariosService.obtenerPorId(propietario.getId());
            if (propietarioExistente != null) {
                propietarioExistente.setNombre(propietario.getNombre());
                propietarioExistente.setDireccion(propietario.getDireccion());
                propietarioExistente.setTelefono(propietario.getTelefono());
                propietariosService.guardar(propietarioExistente);
            }
        } else {
            propietariosService.guardar(propietario);
        }

        return "redirect:/propietarios/listar";
    }


    @GetMapping("/editar/{id}")
    public String editarPropietario(@PathVariable("id") int id, Model model) {
        model.addAttribute("propietario", propietariosService.obtenerPorId(id));
        return "formPropietario";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarPropietario(@PathVariable("id") int id) {
        propietariosService.eliminar(id);
        return "redirect:/propietarios/listar";
    }
}
