package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDAO {

    private final EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarCategoria(final Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public Categoria consultarCategoria(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public void atualizarCategoria(final Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void excluirCategoria(final Categoria categoria) {
        this.entityManager.remove(categoria);
    }
}
