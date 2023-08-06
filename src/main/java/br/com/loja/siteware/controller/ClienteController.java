package br.com.loja.siteware.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Cliente;
import br.com.loja.siteware.service.impl.ClienteServiceImpl;

@Controller
public class ClienteController {

  @Autowired
  private ClienteServiceImpl service;

  @GetMapping("/cliente/cadastrar")
  public ModelAndView cadastrar(Cliente cliente) {
    return service.cadastrar(cliente);
  }

  @GetMapping("/cliente/logar")
  public ModelAndView logar(Cliente cliente) {
    return service.logar(cliente);
  }

  @GetMapping("/cliente/editar/{id}")
  public ModelAndView editar(@PathVariable("id") Long id) {
    return service.atualizar(id);
  }

  @PostMapping("/cliente/salvar")
  public ModelAndView salvar(@Valid Cliente cliente, BindingResult result) {
    if (result.hasErrors()) {
      return cadastrar(cliente);
    }

    service.salvar(cliente);

    return cadastrar(new Cliente());
  }
}
