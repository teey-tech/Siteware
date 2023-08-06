package br.com.loja.siteware.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Produto;
import br.com.loja.siteware.repository.ProdutoRepository;
import br.com.loja.siteware.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

  @Autowired
  private ProdutoRepository repository;

  @Override
  public ModelAndView cadastrar(Produto produto) {
    ModelAndView mv = new ModelAndView("admin/produtos/cadastro");
    mv.addObject("produto", produto);
    return mv;
  }

  @Override
  public ModelAndView salvar(Produto produto) {
    repository.saveAndFlush(produto);
    return cadastrar(new Produto());
  }

  @Override
  public ModelAndView listar() {
    ModelAndView mv = new ModelAndView("admin/produtos/lista");
    mv.addObject("listaProdutos", repository.findAll());
    return mv;
  }

  @Override
  public ModelAndView atualizar(Long id) {
    Optional<Produto> produtoEncontrado = repository.findById(id);
    return this.cadastrar(produtoEncontrado.get());
  }

  @Override
  public ModelAndView deletar(Long id) {
    Optional<Produto> funcionarioEncontrado = repository.findById(id);
    repository.delete(funcionarioEncontrado.get());
    return this.listar();
  }

}
