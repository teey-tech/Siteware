package br.com.loja.siteware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/admin")
  public String acessarPrincipal() {
    return "admin/home";
  }
}
