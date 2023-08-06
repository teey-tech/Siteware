package br.com.loja.siteware.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Papel;
import br.com.loja.siteware.repository.PapelRepository;
import br.com.loja.siteware.service.PapelService;

@Service
public class PapelServiceImpl implements PapelService {

  @Autowired
  private PapelRepository repository;

  @Override
  public ModelAndView cadastrar(Papel papel) {
    ModelAndView mv = new ModelAndView("admin/papeis/cadastro");
    mv.addObject("papel", papel);
    return mv;
  }

  @Override
  public ModelAndView salvar(Papel papel) {
    repository.saveAndFlush(papel);
    return cadastrar(new Papel());
  }

  @Override
  public ModelAndView listar() {
    ModelAndView mv = new ModelAndView("admin/papeis/lista");
    mv.addObject("listaPapeis", repository.findAll());
    return mv;
  }

  @Override
  public ModelAndView atualizar(Long id) {
    Optional<Papel> papelEncontrado = repository.findById(id);
    return this.cadastrar(papelEncontrado.get());
  }

  @Override
  public ModelAndView deletar(Long id) {
    Optional<Papel> papelEncontrado = repository.findById(id);
    repository.delete(papelEncontrado.get());
    return this.listar();
  }

}
