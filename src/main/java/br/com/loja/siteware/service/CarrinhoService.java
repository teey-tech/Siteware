package br.com.loja.siteware.service;

import org.springframework.web.servlet.ModelAndView;

public interface CarrinhoService {

  ModelAndView chamarCarrinho();

  ModelAndView chamarFinalizarCompra();

  Void buscarUsuarioLogado();

  String adicionarCarrinho(Long id);

  String alterarQuantidade(Long id, Integer acao);

  String removerProduto(Long id);

  void calcularTotal();

  ModelAndView confirmarCompra(String formaPagamento);
}
