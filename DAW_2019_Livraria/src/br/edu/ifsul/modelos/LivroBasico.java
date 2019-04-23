/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Gabriel Heinz
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "livrobasico")
public class LivroBasico implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_livrobasico", sequenceName = "seq_livrobasico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_livrobasico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O isbn nao pode estar em branco")
    @Length(max = 13, message = "O isbn nao pode ter mais q. {max} caracteres")
    @Column(name = "isbn", length = 13, nullable = false)
    private String isbn;
    @NotBlank(message = "O titulo nao pode estar em branco")
    @Length(max = 20, message = "O titulo nao pode ter mais q. {max} caracteres")
    @Column(name = "titulo", length = 20, nullable = false)
    private String titulo;
    @NotBlank(message = "O resumo nao pode estar em branco")
    @Length(max = 100, message = "O resumo nao pode ter mais q. {max} caracteres")
    @Column(name = "resumo", length = 100, nullable = false)
    private String resumo;
    @NotBlank(message = "A editora nao pode estar em branco")
    @Length(max = 20, message = "A editora nao pode ter mais q. {max} caracteres")
    @Column(name = "editora", length = 20, nullable = false)
    private String editora;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_publicacao", nullable = false)
    private Calendar data_publicacao;
    private Autor autor;

    public LivroBasico() {

    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * @return the data_publicacao
     */
    public Calendar getData_publicacao() {
        return data_publicacao;
    }

    /**
     * @param data_publicacao the data_publicacao to set
     */
    public void setData_publicacao(Calendar data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
