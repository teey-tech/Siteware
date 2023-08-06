package br.com.loja.siteware.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Produto;
import br.com.loja.siteware.service.impl.ProdutoServiceImpl;

@Controller
public class ProdutoController {

  @Autowired
  private ProdutoServiceImpl service;

  @GetMapping("/admin/produtos/cadastrar")
  public ModelAndView cadastrar(Produto produto) {
    return service.cadastrar(produto);
  }

  @GetMapping("/admin/produtos/listar")
  public ModelAndView listar() {
    return service.listar();
  }

  @GetMapping("/admin/produtos/editar/{id}")
  public ModelAndView editar(@PathVariable("id") Long id) {
    return service.atualizar(id);
  }

  @GetMapping("/admin/produtos/remover/{id}")
  public ModelAndView remover(@PathVariable("id") Long id) {
    return service.deletar(id);
  }

  @PostMapping("/admin/produtos/salvar")
  public ModelAndView salvar(@Valid Produto produto, BindingResult result) {
    if (result.hasErrors()) {
      return cadastrar(produto);
    }

    service.salvar(produto);

    return cadastrar(new Produto());
  }
}
