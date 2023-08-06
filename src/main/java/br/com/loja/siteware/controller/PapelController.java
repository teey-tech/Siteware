package br.com.loja.siteware.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Papel;
import br.com.loja.siteware.service.impl.PapelServiceImpl;

@Controller
public class PapelController {

  @Autowired
  private PapelServiceImpl service;

  @GetMapping("/admin/papeis/cadastrar")
  public ModelAndView cadastrar(Papel papel) {
    return service.cadastrar(papel);
  }

  @GetMapping("/admin/papeis/listar")
  public ModelAndView listar() {
    return service.listar();
  }

  @GetMapping("/admin/papeis/editar/{id}")
  public ModelAndView editar(@PathVariable("id") Long id) {
    return service.atualizar(id);
  }

  @GetMapping("/admin/papeis/remover/{id}")
  public ModelAndView remover(@PathVariable("id") Long id) {
    return service.deletar(id);
  }

  @PostMapping("/admin/papeis/salvar")
  public ModelAndView salvar(@Valid Papel papel, BindingResult result) {
    if (result.hasErrors()) {
      return cadastrar(papel);
    }

    service.salvar(papel);

    return cadastrar(new Papel());
  }
}
