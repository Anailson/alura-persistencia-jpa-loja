package br.com.alura.loja.testes;

import java.math.BigDecimal;

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
			
			Categoria celulares = new Categoria("CELULARES");
			
			Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
					
			EntityManager em = JPAUtil.getEntityManager();
			//ProdutoDao produtoDao = new ProdutoDao(em);
			//CategoriaDao categoriaDao = new CategoriaDao(em);
			
			em.getTransaction().begin();
			
			em.persist(celulares);
			celulares.setNome("XPTO");
			
					
			//categoriaDao.cadastrar(celulares);
			//produtoDao.cadastrar(celular);
			
			em.flush();
			em.clear();
			
			celulares = em.merge(celulares);
			celulares.setNome("1234");
			em.flush();
			em.clear();
			em.remove(celulares);
			em.flush();
		}

}
