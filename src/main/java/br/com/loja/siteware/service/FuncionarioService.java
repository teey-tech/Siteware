package br.com.loja.siteware.service;

import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Funcionario;

public interface FuncionarioService {

  ModelAndView cadastrar(Funcionario funcionario);

  ModelAndView salvar(Funcionario funcionario);

  ModelAndView listar();

  ModelAndView atualizar(Long id);

  ModelAndView deletar(Long id);
}
