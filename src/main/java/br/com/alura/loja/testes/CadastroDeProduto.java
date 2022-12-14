package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
		public static void main(String[] args) {
			
			CadastrarProduto();
			EntityManager em = JPAUtil.getEntityManager();
			ProdutoDao produtoDao = new ProdutoDao(em);
			
			Produto p = produtoDao.buscarPorId(1l);
			System.out.println(p.getPreco());
			
			//List<Produto> todos = produtoDao.buscarTodos();
			//todos.forEach(p2 -> System.out.print(p.getNome()));
			
			//List<Produto> todos = produtoDao.buscarPorNome("Xiaomi Redmi");
			//todos.forEach(p2 -> System.out.print(p.getNome()));
			
			List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
			todos.forEach(p2 -> System.out.print(p.getNome()));
			
			BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
			System.out.println("Pre?o do produto: " + precoDoProduto);
			
		}

		private static void CadastrarProduto() {
			Categoria celulares = new Categoria("CELULARES");
			
			Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
					
			EntityManager em = JPAUtil.getEntityManager();
			ProdutoDao produtoDao = new ProdutoDao(em);
			CategoriaDao categoriaDao = new CategoriaDao(em);
			
			em.getTransaction().begin();
			
		
					
			categoriaDao.cadastrar(celulares);
			produtoDao.cadastrar(celular);
			
			
			em.getTransaction().commit();
			em.close();
		}

}
