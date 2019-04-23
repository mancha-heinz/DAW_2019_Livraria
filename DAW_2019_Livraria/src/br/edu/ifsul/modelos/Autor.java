/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Gabriel Heinz
 */
@Entity
public class Autor implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome nao pode ser em branco")
    @Length(max=20, message = "O nome nao pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 20, nullable = false)
    private String nome;
    @NotBlank(message = "A bibliografia nao pode ser em branco")
    @Length(max=100, message = "A bibliografia nao pode ter mais que {max} caracteres")
    @Column(name = "bibliografia", length = 100, nullable = false)
    private String bibliografia;
    private LivroBasico livro_basico;

    public Autor() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the bibliografia
     */
    public String getBibliografia() {
        return bibliografia;
    }

    /**
     * @param bibliografia the bibliografia to set
     */
    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    /**
     * @return the livro_basico
     */
    public LivroBasico getLivro_basico() {
        return livro_basico;
    }

    /**
     * @param livro_basico the livro_basico to set
     */
    public void setLivro_basico(LivroBasico livro_basico) {
        this.livro_basico = livro_basico;
    }
    
    
}
