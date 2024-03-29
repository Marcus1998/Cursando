/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Instituicao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Roberta
 */
public class InstituicaoDAO {
    public void salvar(Instituicao instituicao) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(instituicao);
        em.getTransaction().commit();
        em.close();
    }
    
    public void atualizar(Instituicao instituicao) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(instituicao);
        em.getTransaction().commit();
        em.close();
    }
    
    public void remover(Instituicao instituicao) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(instituicao);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Instituicao> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Instituicao> query = em.createQuery("SELECT i FROM Instituicao i", Instituicao.class);
        List<Instituicao> instituicoes = query.getResultList();
        em.close();
        return instituicoes;
    }
    
    public Instituicao buscarId(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Instituicao instituicao = em.find(Instituicao.class, id);
        em.close();
        return instituicao;
    }
    
    public Instituicao logar(Instituicao i){
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Instituicao> query = em.createQuery("SELECT i FROM Instituicao i " + "where i.nome = '" + i.getNome() + "' and i.senha = '" + i.getSenha() + "'",Instituicao.class);
        List<Instituicao> instituicoes = query.getResultList();
        for(Instituicao instituicao : instituicoes){
            em.close();
            System.out.println(instituicao.toString());
            return instituicao;
            
        }
        return null;
    }
    
   
    
    
}
