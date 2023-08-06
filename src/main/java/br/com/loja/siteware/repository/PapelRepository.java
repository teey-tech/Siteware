package br.com.loja.siteware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.siteware.model.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {

}
