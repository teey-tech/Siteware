package br.com.loja.siteware.service;

import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.EntradaItens;
import br.com.loja.siteware.model.EntradaProduto;

public interface EntradaProdutoService {

  ModelAndView cadastrar(EntradaProduto entrada, EntradaItens entradaItens);

  ModelAndView salvar(String acao, EntradaProduto entrada, EntradaItens entradaItens);
}
