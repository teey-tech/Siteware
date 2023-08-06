package br.com.loja.siteware.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entrada_itens")
@Getter
@Setter
@NoArgsConstructor
public class EntradaItens implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private EntradaProduto entrada;

  @ManyToOne
  private Produto produto;

  private Double quantidade = 0.;
  private Double valorProduto = 0.;
  private Double valorVenda = 0.;
}
