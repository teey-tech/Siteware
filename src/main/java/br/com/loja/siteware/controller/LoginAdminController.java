package br.com.loja.siteware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginAdminController {
  @GetMapping("/login")
  public String login() {
    return "admin/login";
  }
}
