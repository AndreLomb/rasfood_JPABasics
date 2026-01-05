package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.PratoDAO;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de Carne");
        risoto.setDescricao("Risoto com músculo feito em pressão");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(85.50));

        Cardapio bacalhau = new Cardapio();
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
