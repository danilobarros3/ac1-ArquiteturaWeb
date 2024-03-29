package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {

  @Autowired
  private EntityManager entityManager;

  @Transactional
  public Produto inserir(Produto produto) {
    this.entityManager.merge(produto);
    return produto;
  }
  
  @Transactional
  public Produto update(Produto produto) {
    this.entityManager.merge(produto);
    return produto;
  }

  @Transactional
  public Produto delete(Produto produto) {
    this.entityManager.remove(produto);
    return produto;
  }

  @Transactional
  public List<Produto> getAll() {
    return this.entityManager.createQuery("SELECT c FROM Produto c", Produto.class).getResultList();
  }

  @Transactional
  public List<Produto> getById(int id) {
    String jpql = "SELECT c FROM Produto c WHERE c.id_produto = :id_produto";
    TypedQuery<Produto> query = entityManager.createQuery(jpql,Produto.class);

    query.setParameter("id_produto", id);
    return query.getResultList();  
  }

}

