package br.com.iprsaojose.iprsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    //Renderização do index
    @GetMapping(value={"/","/index","/login"})
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value={"index-error"})
    public ModelAndView getIndexError() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index-error");
        return modelAndView;
    }

    //Sistema de autenticação
    //@GetMapping(value={"/sistema/home"})
    //public ModelAndView getLogin(){
    //    ModelAndView modelAndView = new ModelAndView();
    //    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //    User user = userService.findUserByUserName(auth.getName());
    //    modelAndView.addObject("userName", "Bem vindo " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
    //    modelAndView.addObject("adminMessage","Conteúdo autorizado apenas para usuários admin");
    //   modelAndView.setViewName("sistema");
    //    return modelAndView;
    //}
 
}