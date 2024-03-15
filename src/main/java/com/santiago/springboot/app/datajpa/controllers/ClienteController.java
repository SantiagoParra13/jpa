package com.santiago.springboot.app.datajpa.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.santiago.springboot.app.datajpa.models.entity.Cliente;
import com.santiago.springboot.app.datajpa.models.service.IClienteService;

import jakarta.validation.Valid;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Clientes: ");
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }

    @GetMapping("form")
    public String crear(Map<String, Object> model) {
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Cliente");
        return "form";
    }

    @GetMapping("/edit/{id}") // Cambio de "/form{id}" a "/edit/{id}"
    public String editar(@PathVariable(value = "id") long id, Map<String, Object> model) {

        Cliente cliente = null;

        if (id > 0) {
            cliente = clienteService.findONe(id);
            if (cliente == null) {
                // Manejar el caso en el que no se encuentra un cliente con el ID proporcionado.
                return "redirect:/listar";
            }
        } else {
            // Manejar el caso en el que el ID es inválido.
            return "redirect:/listar";
        }

        model.put("cliente", cliente);
        model.put("titulo", "Editar Cliente");
        return "form";
    }

    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "formulario de Cliente");
            return "form";
        }

        if (cliente != null) {
            clienteService.save(cliente);
        }
        return "redirect:listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {

        if (id > 0) {
            clienteService.delete(id);
        }

        return "redirect:/listar";
    }
}
