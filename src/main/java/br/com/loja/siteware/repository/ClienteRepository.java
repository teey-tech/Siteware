package br.com.loja.siteware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.loja.siteware.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  // Primeiro elemento do parametro
  @Query("from Cliente where email=?1")
  public List<Cliente> buscarClienteEmail(String email);
}
