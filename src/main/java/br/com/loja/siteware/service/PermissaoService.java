package br.com.loja.siteware.service;

import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Permissao;

public interface PermissaoService {
  ModelAndView cadastrar(Permissao permissao);

  ModelAndView salvar(Permissao permissao);

  ModelAndView listar();

  ModelAndView atualizar(Long id);

  ModelAndView deletar(Long id);
}
