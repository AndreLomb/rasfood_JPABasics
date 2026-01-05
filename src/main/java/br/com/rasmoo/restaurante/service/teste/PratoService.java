package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.PratoDAO;
import br.com.rasmoo.restaurante.entity.Prato;
import br.com.rasmoo.restaurante.util.JPAUtil;
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

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        PratoDAO pratoDAO = new PratoDAO(entityManager);
        entityManager.getTransaction().begin();
        pratoDAO.cadastrar(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
