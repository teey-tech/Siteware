package br.com.loja.siteware.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Funcionario;
import br.com.loja.siteware.service.impl.FuncionarioServiceImpl;

@Controller
public class FuncionarioController {

  @Autowired
  private FuncionarioServiceImpl service;

  @GetMapping("/admin/funcionarios/cadastrar")
  public ModelAndView cadastrar(Funcionario funcionario) {
    return service.cadastrar(funcionario);
  }

  @GetMapping("/admin/funcionarios/listar")
  public ModelAndView listar() {
    return service.listar();
  }

  @GetMapping("/admin/funcionarios/editar/{id}")
  public ModelAndView editar(@PathVariable("id") Long id) {
    return service.atualizar(id);
  }

  @GetMapping("/admin/funcionarios/remover/{id}")
  public ModelAndView remover(@PathVariable("id") Long id) {
    return service.deletar(id);
  }

  @PostMapping("/admin/funcionarios/salvar")
  public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result) {
    if (result.hasErrors()) {
      return cadastrar(funcionario);
    }

    service.salvar(funcionario);

    return cadastrar(new Funcionario());
  }
}
