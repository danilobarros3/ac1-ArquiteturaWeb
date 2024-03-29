package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.entity.CategoriaProduto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    
    // Injeção de dependência do EntityManager
    @Autowired
    private EntityManager entityManager;

    // Método para inserir uma nova categoria no banco de dados
    @Transactional
    public CategoriaProduto inserir(CategoriaProduto categoria) {
        this.entityManager.merge(categoria);
        return categoria;
    }
    
    // Método para deletar uma categoria do banco de dados
    @Transactional
    public CategoriaProduto delete(CategoriaProduto categoria) {
        this.entityManager.remove(categoria);
        return categoria;
    }
    
    // Método para atualizar uma categoria no banco de dados
    @Transactional
    public CategoriaProduto update(CategoriaProduto categoria) {
        this.entityManager.merge(categoria);
        return categoria;
    }

    // Método para obter todas as categorias do banco de dados
    @Transactional
    public List<CategoriaProduto> getAll() {
        return this.entityManager.createQuery("SELECT c FROM CategoriaProduto c", CategoriaProduto.class).getResultList();
    }
    
    // Método para obter uma categoria pelo seu ID
    @Transactional
    public List<CategoriaProduto> getById(int id) {
        String jpql = "SELECT c FROM CategoriaProduto c WHERE c.id_categoria = :id_categoria";
        TypedQuery<CategoriaProduto> query = entityManager.createQuery(jpql, CategoriaProduto.class);
        query.setParameter("id_categoria", id);
        return query.getResultList();  
    }
}
