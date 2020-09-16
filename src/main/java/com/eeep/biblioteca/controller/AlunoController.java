package com.eeep.biblioteca.controller;

import com.eeep.biblioteca.model.Aluno;
import com.eeep.biblioteca.repository.RepositoryAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;
import java.time.LocalDate;

@Controller
public class AlunoController {
    @Autowired
    RepositoryAluno repositoryAluno;

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String cadastro(){
        return "cadastro.html";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public String salvar(Aluno aluno){
        repositoryAluno.save(aluno);
        return "redirect:/cadastro";
    }

    @RequestMapping(value = "excluir/{matricula}", method = RequestMethod.GET)
    public String excluir(@PathVariable("matricula") int matricula){
        repositoryAluno.deleteById(matricula);
        return "redirect:/consulta";
    }

    @RequestMapping(value="editar/{matricula}", method = RequestMethod.GET)
    public String editar(@PathVariable("matricula") Integer matricula, Model model) {
        model.addAttribute("dados", repositoryAluno.findById(matricula));
        return "atualizar";
    }

    @RequestMapping(value = "/consulta", method = RequestMethod.GET)
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("consultar");
        modelAndView.addObject("alunos", repositoryAluno.findAll());
        return modelAndView;
    }
}
