/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.Entity_manager_util;
import br.edu.ifsul.modelos.Catalogo;
import br.edu.ifsul.modelos.Formato;
import br.edu.ifsul.modelos.Idioma;
import br.edu.ifsul.modelos.Livro;
import br.edu.ifsul.modelos.LivroBasico;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel Heinz
 */
public class TesteAdicionaLivroBasico {

    EntityManager em;

    public TesteAdicionaLivroBasico() {
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
        try {
            Livro lb = new Livro();
            //LivroBasico lb = new LivroBasico();
           lb.setIsbn("321");
            lb.setTitulo("culpa_estrelas");
            lb.setResumo("garota com cancer");
            lb.setEditora("novo seculo");
            
            SimpleDateFormat datap = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = datap.parse("01/01/2011");
            Calendar dtp = Calendar.getInstance();
            dtp.setTime(dt);
            lb.setData_publicacao(dtp);
                      
            lb.setNumero_paginas(100);
            lb.setCodigo_barras("90909090");
            lb.setAtivo(Boolean.TRUE);
            
            SimpleDateFormat datac = new SimpleDateFormat("dd/MM/yyyy");
            Date dtn = datac.parse("01/01/2010");
            Calendar dtc = Calendar.getInstance();
            dtc.setTime(dtn);
            lb.setData_cadastro(dtc);            
            lb.setValor(100.00);
            
            lb.setIdioma(em.find(Idioma.class, 3));
            lb.setFormato(em.find(Formato.class, 2));
            lb.setCatalogo(em.find(Catalogo.class, 2));
            
            System.out.println("Teste" + lb);
            em.getTransaction().begin();
            em.persist(lb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro " + e);
        }
    }
}
