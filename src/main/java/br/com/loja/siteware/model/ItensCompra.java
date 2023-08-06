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
@Table(name = "itens_compra")
@Getter
@Setter
@NoArgsConstructor
public class ItensCompra implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Produto produto;

  @ManyToOne
  private Compra compra;

  private Integer quantidade = 0;

  private Double valorUnitario = 0.;

  private Double valorTotal = 0.;
}
