package br.com.loja.siteware.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@NoArgsConstructor
public class Funcionario implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String email;
  private String senha;

  private Double salarioBruto;

  @Temporal(TemporalType.DATE)
  private Date dataEntrada;

  @Temporal(TemporalType.DATE)
  private Date dataSaida;

  private String cargo;

  private String cidade;

  private String logradouro;

  private String numero;

  private String complemento;

  private String bairro;

  private String uf;

  private String cep;
}
