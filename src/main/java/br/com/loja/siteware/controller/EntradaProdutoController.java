package br.com.loja.siteware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.EntradaItens;
import br.com.loja.siteware.model.EntradaProduto;
import br.com.loja.siteware.service.impl.EntradaProdutoServiceImpl;

@Controller
public class EntradaProdutoController {

  @Autowired
  private EntradaProdutoServiceImpl sevice;

  @GetMapping("/admin/entrada/cadastrar")
  public ModelAndView cadastrar(EntradaProduto entrada, EntradaItens entradaItens) {
    return sevice.cadastrar(entrada, entradaItens);
  }

  @PostMapping("/admin/entrada/salvar")
  public ModelAndView salvar(String acao, EntradaProduto entrada, EntradaItens entradaItens) {
    return sevice.salvar(acao, entrada, entradaItens);
  }
}
