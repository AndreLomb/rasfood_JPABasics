package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.entity.Prato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        Prato risoto = new Prato();
        risoto.setNome("Risoto de Carne");
        risoto.setDescricao("Risoto com músculo feito em pressão");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(85.50));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rasfood");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
