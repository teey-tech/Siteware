package br.com.loja.siteware.service;

import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Produto;

public interface ProdutoService {

  ModelAndView cadastrar(Produto produto);

  ModelAndView salvar(Produto produto);

  ModelAndView listar();

  ModelAndView atualizar(Long id);

  ModelAndView deletar(Long id);
}
