package com.example.ac1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idProduto;

  @Column(nullable = false)
  private int quantidadeProduto;
  
  @ManyToOne()
  @JoinColumn(name="categoria_id")
  private CategoriaProduto categoriaProduto;

  @Column(nullable = false)
  private String prodName;

  public Produto(int idProduto, int quantidadeProduto, String prodName) {
    this.idProduto = idProduto;
    this.quantidadeProduto = quantidadeProduto;
    this.prodName = prodName;
  }

  public Produto() {
  }

  public int getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(int idProduto) {
    this.idProduto = idProduto;
  }

  public int getquantidadeProduto() {
    return quantidadeProduto;
  }

  public void setquantidadeProduto(int quantidadeProduto) {
    this.quantidadeProduto = quantidadeProduto;
  }

  public String getProdName() {
    return prodName;
  }
  public CategoriaProduto getCategoriaProduto() {
    return categoriaProduto;
  }

  public void setProdName(String prodName) {
    this.prodName = prodName;
  }


  public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
    this.categoriaProduto = categoriaProduto;
  }

  @Override
  public String toString() {
    return "Produto [idProduto=" + idProduto + ", quantidadeProduto=" + quantidadeProduto + ", categoriaProduto=" + categoriaProduto
        + ", prodName=" + prodName + "]";
  }
 
}
