package com.bolsadeideas.springboot.springboot.form.app.controllers;

import com.bolsadeideas.springboot.springboot.form.app.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Camila");
        usuario.setApellido("Torres");
        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario",usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {

        model.addAttribute("titulo", "Resultado form");

        if(result.hasErrors()){



            //Forma larga
//            Map <String, String> errores= new HashMap<>();
//            result.getFieldErrors().forEach(error -> {
//                errores.put(error.getField(),"El campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
//            });
//            model.addAttribute("error",errores);
            return "form";
        }

        model.addAttribute("usuario", usuario);

        return "resultado";
    }

}
