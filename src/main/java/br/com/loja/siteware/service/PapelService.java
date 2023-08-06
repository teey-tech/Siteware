package br.com.loja.siteware.service;

import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Papel;

public interface PapelService {

  ModelAndView cadastrar(Papel papel);

  ModelAndView salvar(Papel papel);

  ModelAndView listar();

  ModelAndView atualizar(Long id);

  ModelAndView deletar(Long id);
}
