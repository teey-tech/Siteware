package br.com.loja.siteware.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Funcionario;
import br.com.loja.siteware.repository.FuncionarioRepository;
import br.com.loja.siteware.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

  @Autowired
  private FuncionarioRepository repository;

  @Override
  public ModelAndView cadastrar(Funcionario funcionario) {
    ModelAndView mv = new ModelAndView("admin/funcionarios/cadastro");
    mv.addObject("funcionario", funcionario);
    return mv;
  }

  @Override
  public ModelAndView salvar(Funcionario funcionario) {
    funcionario.setSenha(new BCryptPasswordEncoder().encode(funcionario.getSenha()));
    repository.saveAndFlush(funcionario);
    return cadastrar(new Funcionario());
  }

  @Override
  public ModelAndView listar() {
    ModelAndView mv = new ModelAndView("admin/funcionarios/lista");
    mv.addObject("listaFuncionarios", repository.findAll());
    return mv;
  }

  @Override
  public ModelAndView atualizar(Long id) {
    Optional<Funcionario> funcionarioEncontrado = repository.findById(id);
    return this.cadastrar(funcionarioEncontrado.get());
  }

  @Override
  public ModelAndView deletar(Long id) {
    Optional<Funcionario> funcionarioEncontrado = repository.findById(id);
    repository.delete(funcionarioEncontrado.get());
    return this.listar();
  }

}
