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

        Prato bacalhau = new Prato();
        bacalhau.setNome("Bacalhau");
        bacalhau.setDescricao("Um prato típico Português, com anchovas e molho branco.");
        bacalhau.setDisponivel(true);
        bacalhau.setValor(BigDecimal.valueOf(97.50));

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        PratoDAO pratoDAO = new PratoDAO(entityManager);
        entityManager.getTransaction().begin();
        pratoDAO.cadastrar(risoto);
        entityManager.flush();
        pratoDAO.cadastrar(bacalhau);
        entityManager.flush();
        System.out.println("O prato consultado foi: " + pratoDAO.consultar(1));

        pratoDAO.excluir(bacalhau);
        System.out.println("O prato consultado foi: " + pratoDAO.consultar(2));

        entityManager.clear();
        risoto.setValor(BigDecimal.valueOf(75.50));
        pratoDAO.atualizar(risoto);
        System.out.println("O prato consultado foi: " + pratoDAO.consultar(1));
    }
}
