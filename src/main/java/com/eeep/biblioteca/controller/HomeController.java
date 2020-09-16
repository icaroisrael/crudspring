package com.eeep.biblioteca.controller;
import com.eeep.biblioteca.repository.RepositoryAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    RepositoryAluno aluno;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("alunos", aluno.findAll());
        return model;
    }
}
