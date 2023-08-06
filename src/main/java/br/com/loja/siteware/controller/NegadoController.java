package br.com.loja.siteware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NegadoController {

  @GetMapping("/negadoAdministrativo")
  public String negadoAdministrativo() {
    return "admin/negadoAdministrativo";
  }

  @GetMapping("/negado")
  public String negado() {
    return "cliente/negadoAdministrativo";
  }
}
