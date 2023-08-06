package br.com.loja.siteware.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Permissao;
import br.com.loja.siteware.service.impl.PermissaoServiceImpl;

@Controller
public class PermissaoController {

  @Autowired
  private PermissaoServiceImpl service;

  @GetMapping("/admin/permissoes/cadastrar")
  public ModelAndView cadastrar(Permissao permissao) {
    return service.cadastrar(permissao);
  }

  @GetMapping("/admin/permissoes/listar")
  public ModelAndView listar() {
    return service.listar();
  }

  @GetMapping("/admin/permissoes/editar/{id}")
  public ModelAndView editar(@PathVariable("id") Long id) {
    return service.atualizar(id);
  }

  @GetMapping("/admin/permissoes/remover/{id}")
  public ModelAndView remover(@PathVariable("id") Long id) {
    return service.deletar(id);
  }

  @PostMapping("/admin/permissoes/salvar")
  public ModelAndView salvar(@Valid Permissao permissao, BindingResult result) {
    if (result.hasErrors()) {
      return cadastrar(permissao);
    }

    service.salvar(permissao);

    return cadastrar(new Permissao());
  }
}
