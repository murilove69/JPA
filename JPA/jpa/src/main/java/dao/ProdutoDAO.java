package dao;

import model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoDAO {
    // Cria os EntityManagers utilizando uma unidade de persistência chamada "produtoPU".
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");

    // Método para criar (inserir) um novo produto no banco de dados.
    public void criar(Produto produto) {
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin(); 
        em.persist(produto); 
        em.getTransaction().commit(); 
        em.close(); 
    }

    // Método para ler (buscar) um produto específico pelo seu ID.
    public Produto ler(Long id) {
        EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, id); 
        em.close(); 
        return produto;
    }

    // Método para listar todos os produtos do banco de dados.
    public List<Produto> listarTodos() {
        EntityManager em = emf.createEntityManager(); 
        
        // Realiza uma consulta para obter todos os objetos Produto.
        List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList();
        em.close();
        return produtos; 
    }

    // Método para atualizar as informações de um produto existente no banco de dados.
    public void atualizar(Produto produto) {
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin(); 
        em.merge(produto); 
        em.getTransaction().commit(); 
        em.close(); 
    }

    // Método para excluir um produto do banco de dados pelo ID.
    public void excluir(Long id) {
        EntityManager em = emf.createEntityManager(); 
        Produto produto = em.find(Produto.class, id); 
        if (produto != null) { 
            em.getTransaction().begin(); 
            em.remove(produto);
            em.getTransaction().commit();
        }
        em.close(); 
    }
}
