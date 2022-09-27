package br.com.iprsaojose.iprsys.controller;

import java.util.List;

import br.com.iprsaojose.iprsys.model.Membro;
import br.com.iprsaojose.iprsys.service.MembroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MembroController {

    @Autowired
    MembroService membroService;

    @GetMapping(value="/sistema/mostrarmembros/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        Membro membro = membroService.findById(id);
        ModelAndView modelAndView = new ModelAndView("mostrarmembros");
        modelAndView.addObject("membro", membro);
        return modelAndView;
    }

    @PostMapping(value="/sistema/mostrarmembros")
    public ModelAndView getMostrarMembros(@PathVariable Long id) {
        Membro membro = membroService.findById(id);
        ModelAndView modelAndView = new ModelAndView("mostrarmembros");
        modelAndView.addObject("membro", membro);
        return modelAndView;
    }



    @GetMapping(value="/sistema/cadastrarmembros")
    public ModelAndView getCadastrar() {
        Membro membro = new Membro();
        ModelAndView modelAndView = new ModelAndView("cadastrarmembros");
        modelAndView.addObject("membro", membro);
        return modelAndView;
    }

    @PostMapping(value="/sistema/cadastrarmembros")
    public ModelAndView postCadastrar(Membro membro) {
        Membro membroSalvo = membroService.save(membro);
        return getMostrar(membroSalvo.getId());
    }

    
    @GetMapping(value="/sistema/editarmembro/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        Membro membro = membroService.findById(id);
        ModelAndView modelAndView = new ModelAndView("cadastrarmembros");
        modelAndView.addObject("membro", membro);
        return modelAndView;
    }
    @GetMapping(value="/sistema/buscarmembros")
    public ModelAndView getListar() {
        List<Membro> lista = membroService.findAll();
        ModelAndView modelAndView = new ModelAndView("buscarmembros");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
     
    
}
