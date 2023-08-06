package br.com.loja.siteware.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.EntradaItens;
import br.com.loja.siteware.model.EntradaProduto;
import br.com.loja.siteware.model.Produto;
import br.com.loja.siteware.repository.EntradaItensRepository;
import br.com.loja.siteware.repository.EntradaProdutoRepository;
import br.com.loja.siteware.repository.FuncionarioRepository;
import br.com.loja.siteware.repository.ProdutoRepository;
import br.com.loja.siteware.service.EntradaProdutoService;

@Service
public class EntradaProdutoServiceImpl implements EntradaProdutoService {

  @Autowired
  private EntradaProdutoRepository entradaProdutoRepository;

  @Autowired
  private EntradaItensRepository entradaItensRepository;

  @Autowired
  private FuncionarioRepository funcionarioRepository;

  @Autowired
  private ProdutoRepository produtoRepository;

  private List<EntradaItens> listaEntrada = new ArrayList<EntradaItens>();

  @Override
  public ModelAndView cadastrar(EntradaProduto entrada, EntradaItens entradaItens) {
    ModelAndView mv = new ModelAndView("admin/entrada/cadastro");
    mv.addObject("entrada", entrada);
    mv.addObject("listaEntradaItens", this.listaEntrada);
    mv.addObject("entradaItens", entradaItens);
    mv.addObject("listaFuncionarios", funcionarioRepository.findAll());
    mv.addObject("listaProdutos", produtoRepository.findAll());
    return mv;
  }

  @Override
  public ModelAndView salvar(String acao, EntradaProduto entrada, EntradaItens entradaItens) {
    if (acao.equals("itens")) {
      this.listaEntrada.add(entradaItens);
    } else if (acao.equals("salvar")) {
      entradaProdutoRepository.saveAndFlush(entrada);
      for (EntradaItens it : listaEntrada) {
        it.setEntrada(entrada);
        entradaItensRepository.saveAndFlush(it);
        Optional<Produto> produtoEncontrado = produtoRepository.findById(it.getProduto().getId());
        Produto produto = produtoEncontrado.get();
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + it.getQuantidade());
        produto.setPreco(it.getValorVenda());
        produtoRepository.saveAndFlush(produto);
        this.listaEntrada = new ArrayList<>();
      }
      return cadastrar(new EntradaProduto(), new EntradaItens());
    }
    return cadastrar(entrada, new EntradaItens());
  }
}
