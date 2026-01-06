package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CardapioDAO {

    private final EntityManager entityManager;

    public CardapioDAO(EntityManager entityManager) {
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

    public Cardapio consultarPorId(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarTodos(){
        String sql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
    }

    public void atualizar(final Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
