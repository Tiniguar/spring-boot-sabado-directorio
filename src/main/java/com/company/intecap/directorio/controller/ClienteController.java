package com.company.intecap.directorio.controller;

import com.company.intecap.directorio.models.entity.Cliente;
import com.company.intecap.directorio.models.service.IClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    @RequestMapping(value ="/index", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("titulo", "Directorio de Clientes");

        return "index";
    }

    @RequestMapping(value = "/listado", method = RequestMethod.GET)
    public String listado(org.springframework.ui.Model model) {
        model.addAttribute("titulo", "Directorio de Clientes");
        model.addAttribute("clientes", clienteService.findAll());

        return "listado";
    }


    @RequestMapping(value = "/formulario")
    public String crear(Map<String, Object> model) {

        Cliente cliente = new Cliente();

        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Directorio");
        return "formulario";
    }

    @RequestMapping(value = "/formulario", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, org.springframework.ui.Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de cliente");
            return "formulario";
        }

        try{
            clienteService.save(cliente);
            status.setComplete();
            return "redirect:listado";
        }catch (DataIntegrityViolationException e){
            result.rejectValue("nombre","error.cliente","Ya existe un cliente con ese nombre");
            model.addAttribute("titulo","Formulario de cliente");
            return "formulario";
        }
    }

    //Actualizar un Registro
    @RequestMapping(value = "/formulario/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){
        Cliente cliente = null;

        if(id>0){ // seria una actualización
            cliente = clienteService.findOne(id);
        }else{
            return "redirect:/listado";
        }
        model.put("cliente",cliente);
        model.put("titulo","Editar Directorio de Cliente");

        return "formulario";
    }

    // Eliminar un registro
    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        if(id>0){
            clienteService.delete(id);
        }
        return "redirect:/listado";
    }
}
