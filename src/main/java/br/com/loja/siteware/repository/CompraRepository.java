package br.com.loja.siteware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.siteware.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
