package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {
	
		public static void main(String[] args) {
			
			Produto celular = new Produto();
			celular.setNome("Xiaomi Redmi");
			celular.setDescricao("Muito legal");
			celular.setPreco(new BigDecimal("800"));
			
			//loja -> vem do arquivo persistence. E caso tenha outros banco. Será identificado no arquivo persistence.xml
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("loja");
			
			EntityManager em = factory.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(celular);
			em.getTransaction().commit();
			em.close();
			
		}

}
