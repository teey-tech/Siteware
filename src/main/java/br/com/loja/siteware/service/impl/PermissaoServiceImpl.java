package br.com.loja.siteware.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Permissao;
import br.com.loja.siteware.repository.FuncionarioRepository;
import br.com.loja.siteware.repository.PapelRepository;
import br.com.loja.siteware.repository.PermissaoRepository;
import br.com.loja.siteware.service.PermissaoService;

@Service
public class PermissaoServiceImpl implements PermissaoService {

  @Autowired
  private PermissaoRepository repository;

  @Autowired
  private FuncionarioRepository funcionarioRepository;

  @Autowired
  private PapelRepository papelRepository;

  @Override
  public ModelAndView cadastrar(Permissao permissao) {
    ModelAndView mv = new ModelAndView("admin/permissoes/cadastro");
    mv.addObject("permissao", permissao);
    mv.addObject("listaFuncionarios", funcionarioRepository.findAll());
    mv.addObject("listaPapeis", papelRepository.findAll());
    return mv;
  }

  @Override
  public ModelAndView salvar(Permissao permissao) {

    repository.saveAndFlush(permissao);
    return cadastrar(new Permissao());
  }

  @Override
  public ModelAndView listar() {
    ModelAndView mv = new ModelAndView("admin/permissoes/lista");
    mv.addObject("listaPermissoes", repository.findAll());
    return mv;
  }

  @Override
  public ModelAndView atualizar(Long id) {
    Optional<Permissao> permissaoEncontrada = repository.findById(id);

    return this.cadastrar(permissaoEncontrada.get());
  }

  @Override
  public ModelAndView deletar(Long id) {
    Optional<Permissao> permissaoEncontrada = repository.findById(id);
    repository.delete(permissaoEncontrada.get());
    return this.listar();
  }

}
