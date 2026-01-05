package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Prato;
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

    public void cadastrar(final Prato prato) {
        this.entityManager.persist(prato);
        System.out.println("Entidade cadastrada: " + prato);
    }

    public Prato consultar(final Integer id){
        return this.entityManager.find(Prato.class, id);
    }

    public void atualizar(final Prato prato) {
        this.entityManager.merge(prato);
    }

    public void excluir(final Prato prato){
        this.entityManager.remove(prato);
    }
}
