package br.com.loja.siteware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.service.impl.CarrinhoServiceImpl;

@Controller
public class CarrinhoController {

  @Autowired
  private CarrinhoServiceImpl service;

  @GetMapping("/carrinho")
  public ModelAndView chamarCarrinho() {
    return service.chamarCarrinho();
  }

  @GetMapping("/finalizar")
  public ModelAndView chamarFinalizarCompra() {
    return service.chamarFinalizarCompra();
  }

  @GetMapping("/adicionarCarrinho/{id}")
  public String adicionarCarrinho(@PathVariable Long id) {
    return service.adicionarCarrinho(id);
  }

  @GetMapping("/alterarQuantidade/{id}/{acao}")
  public String alterarQuantidade(@PathVariable Long id, @PathVariable Integer acao) {
    return service.alterarQuantidade(id, acao);
  }

  @GetMapping("/removerProduto/{id}")
  public String removerProdutoCarrinho(@PathVariable Long id) {
    return service.removerProduto(id);
  }

  @PostMapping("/finalizar/confirmar")
  public ModelAndView confirmarCompra(String formaPagamento) {
    return service.confirmarCompra(formaPagamento);
  }
}
