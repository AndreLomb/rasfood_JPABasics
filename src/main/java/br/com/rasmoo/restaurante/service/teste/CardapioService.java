package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDAO;
import br.com.rasmoo.restaurante.dao.CategoriaDAO;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));
    }

    private static Categoria cadastrarCategoria(EntityManager entityManager){
        CategoriaDAO categoriaDao = new CategoriaDAO(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }

    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de Carne");
        risoto.setDescricao("Risoto com músculo feito em pressão");
        risoto.setDisponivel(true);
        risoto.setCategoria(categoria);
        risoto.setValor(BigDecimal.valueOf(85.50));

        Cardapio bacalhau = new Cardapio();
        bacalhau.setNome("Bacalhau");
        bacalhau.setDescricao("Um prato típico Português, com anchovas e molho branco.");
        bacalhau.setDisponivel(true);
        bacalhau.setCategoria(categoria);
        bacalhau.setValor(BigDecimal.valueOf(97.50));

        CardapioDAO cardapioDAO = new CardapioDAO(entityManager);
        entityManager.getTransaction().begin();

        cardapioDAO.cadastrar(risoto);
        entityManager.flush();
        cardapioDAO.cadastrar(bacalhau);
        entityManager.flush();
//        System.out.println("O prato consultado foi: " + cardapioDAO.consultarPorId(1));
//        System.out.println("O prato consultado foi: " + cardapioDAO.consultarPorId(2));
        cardapioDAO.consultarTodos().
                forEach(elemento -> System.out.println("O prato consultado foi:" + elemento));

        entityManager.close();
    }
}
