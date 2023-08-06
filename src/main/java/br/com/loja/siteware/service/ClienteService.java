package br.com.loja.siteware.service;

import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Cliente;

public interface ClienteService {

  ModelAndView cadastrar(Cliente cliente);

  ModelAndView logar(Cliente cliente);

  ModelAndView salvar(Cliente cliente);

  ModelAndView atualizar(Long id);

}
