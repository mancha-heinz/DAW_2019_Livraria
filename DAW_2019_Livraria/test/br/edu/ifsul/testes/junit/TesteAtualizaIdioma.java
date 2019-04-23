/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.Entity_manager_util;
import br.edu.ifsul.modelos.Idioma;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel Heinz
 */
public class TesteAtualizaIdioma {
    EntityManager em;
    
    public TesteAtualizaIdioma() {
    }
    
    @Before
    public void setUp() {
        em = Entity_manager_util.getEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void teste() {
        boolean erro=false;
        try {
            Idioma i = em.find(Idioma.class, 3);
            i.setNome("portugues");
            em.getTransaction().begin();
            em.merge(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            erro=true;
            //e.printStackTrace();
            System.out.println("erro: "+e.getMessage());
        }
        Assert.assertEquals(false, erro);

    }
    
}
