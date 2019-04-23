/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.Entity_manager_util;
import br.edu.ifsul.modelos.Catalogo;
import br.edu.ifsul.modelos.Livraria;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel Heinz
 */
public class TesteListaCatalogo {
    EntityManager em;
    
    public TesteListaCatalogo() {
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
        List<Catalogo> catalogo = em.createQuery("from Catalogo").getResultList();
        for(Catalogo c: catalogo){
            System.out.println(c);
        }
    }
    
}
