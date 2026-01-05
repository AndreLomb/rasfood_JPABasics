package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;
import jakarta.persistence.EntityManager;

public class PratoDAO {

    private final EntityManager entityManager;

    public PratoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*CRUD
    C = CREATE
    R = READ
    U = UPDATE
    D = DELETE
    * */

    public void cadastrar(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultar(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
