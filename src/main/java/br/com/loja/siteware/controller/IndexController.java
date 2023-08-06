package br.com.loja.siteware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.siteware.repository.ProdutoRepository;

@Controller
public class IndexController {

  @Autowired
  private ProdutoRepository repository;

  @GetMapping("/")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView("/index");
    mv.addObject("listaProdutos", repository.findAll());
    return mv;
  }
}
