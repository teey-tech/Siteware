package br.com.loja.siteware.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.model.Cliente;
import br.com.loja.siteware.model.Compra;
import br.com.loja.siteware.model.ItensCompra;
import br.com.loja.siteware.model.Produto;
import br.com.loja.siteware.repository.ClienteRepository;
import br.com.loja.siteware.repository.CompraRepository;
import br.com.loja.siteware.repository.ItensCompraRepository;
import br.com.loja.siteware.repository.ProdutoRepository;
import br.com.loja.siteware.service.CarrinhoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

  private List<ItensCompra> itensCompras = new ArrayList<ItensCompra>();
  private Compra compra = new Compra();
  private Cliente cliente;

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private CompraRepository compraRepository;

  @Autowired
  private ItensCompraRepository itensCompraRepository;

  @Override
  public ModelAndView chamarCarrinho() {
    ModelAndView mv = new ModelAndView("cliente/carrinho");
    compra.setValorTotal(0.);
    calcularTotal();
    mv.addObject("compra", compra);
    mv.addObject("listaItens", itensCompras);
    return mv;
  }

  @Override
  public Void buscarUsuarioLogado() {
    Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
    if (!(autenticado instanceof AnonymousAuthenticationToken)) {
      String email = autenticado.getName();
      cliente = clienteRepository.buscarClienteEmail(email).get(0);
    }
    return null;

  }

  @Override
  public ModelAndView chamarFinalizarCompra() {
    buscarUsuarioLogado();
    ModelAndView mv = new ModelAndView("cliente/finalizar");
    compra.setValorTotal(0.);
    calcularTotal();
    mv.addObject("compra", compra);
    mv.addObject("listaItens", itensCompras);
    mv.addObject("cliente", cliente);
    return mv;
  }

  @Override
  public String adicionarCarrinho(Long id) {
    Optional<Produto> produtoEncontrado = produtoRepository.findById(id);
    Produto produto = produtoEncontrado.get();

    int controle = 0;

    for (ItensCompra it : itensCompras) {

      if (it.getProduto().getId().equals(produto.getId())) {
        it.setQuantidade(it.getQuantidade() + 1);
        it.setValorTotal(0.);
        it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
        if (it.getProduto().getPromocao().equals(1) && it.getQuantidade() == 2) {
          it.setValorTotal(0.);
          it.setValorTotal(it.getValorTotal() + it.getValorUnitario());
        }
        if (it.getProduto().getPromocao().equals(2) && it.getQuantidade() == 3) {
          it.setValorTotal(0.);
          it.setValorTotal(10.00);
        }
        controle = 1;
        break;
      }
    }
    if (controle == 0) {
      ItensCompra item = new ItensCompra();
      item.setProduto(produto);
      item.setValorUnitario(produto.getPreco());
      item.setQuantidade(item.getQuantidade() + 1);
      item.setValorTotal(item.getValorTotal() + (item.getQuantidade() * item.getValorUnitario()));
      itensCompras.add(item);
    }
    return "redirect:/carrinho";

  }

  @Override
  public String alterarQuantidade(Long id, Integer acao) {
    for (ItensCompra it : itensCompras) {

      if (it.getProduto().getId().equals(id)) {
        if (acao.equals(1)) {
          it.setQuantidade(it.getQuantidade() + 1);
          it.setValorTotal(0.);
          it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
          if (it.getProduto().getPromocao().equals(1) && it.getQuantidade() == 2) {
            it.setValorTotal(0.);
            it.setValorTotal(it.getValorTotal() + it.getValorUnitario());
          }
          if (it.getProduto().getPromocao().equals(2) && it.getQuantidade() == 3) {
            it.setValorTotal(0.);
            it.setValorTotal(10.00);
          }
        } else if (acao.equals(0)) {
          it.setQuantidade(it.getQuantidade() - 1);
          it.setValorTotal(0.);
          it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
          if (it.getProduto().getPromocao().equals(1) && it.getQuantidade() == 2) {
            it.setValorTotal(0.);
            it.setValorTotal(it.getValorTotal() + it.getValorUnitario());
          }
          if (it.getProduto().getPromocao().equals(2) && it.getQuantidade() == 3) {
            it.setValorTotal(0.);
            it.setValorTotal(10.00);
          }
          if (it.getQuantidade() == 0) {
            itensCompras.remove(it);
            it.setValorTotal(0.);
            it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
            return "redirect:/carrinho";
          }
        }
        break;
      }
    }

    return "redirect:/carrinho";
  }

  @Override
  public String removerProduto(Long id) {
    for (ItensCompra it : itensCompras) {
      if (it.getProduto().getId().equals(id)) {
        itensCompras.remove(it);
        break;
      }
    }

    return "redirect:/carrinho";
  }

  @Override
  public void calcularTotal() {
    for (ItensCompra it : itensCompras) {
      compra.setValorTotal(compra.getValorTotal() + it.getValorTotal());
    }
  }

  @Override
  public ModelAndView confirmarCompra(String formaPagamento) {
    ModelAndView mv = new ModelAndView("cliente/mensagem");
    compra.setCliente(cliente);
    compra.setFormaPagamento(formaPagamento);
    compraRepository.saveAndFlush(compra);

    for (ItensCompra it : itensCompras) {
      it.setCompra(compra);
      itensCompraRepository.saveAndFlush(it);
    }
    itensCompras = new ArrayList<>();
    compra = new Compra();
    return mv;

  }

}
