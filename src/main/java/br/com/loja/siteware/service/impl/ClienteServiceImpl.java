package br.com.loja.siteware.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Cliente;
import br.com.loja.siteware.repository.ClienteRepository;
import br.com.loja.siteware.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private ClienteRepository repository;

  @Override
  public ModelAndView cadastrar(Cliente cliente) {
    ModelAndView mv = new ModelAndView("cliente/cadastrar");
    mv.addObject("cliente", cliente);
    return mv;
  }

  @Override
  public ModelAndView logar(Cliente cliente) {
    ModelAndView mv = new ModelAndView("cliente/logar");
    return mv;
  }

  @Override
  public ModelAndView salvar(Cliente cliente) {
    cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
    repository.saveAndFlush(cliente);
    return cadastrar(new Cliente());
  }

  @Override
  public ModelAndView atualizar(Long id) {
    Optional<Cliente> clienteEncontrado = repository.findById(id);
    return this.cadastrar(clienteEncontrado.get());
  }

}
