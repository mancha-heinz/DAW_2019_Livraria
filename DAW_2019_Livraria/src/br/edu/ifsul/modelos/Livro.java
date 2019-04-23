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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Gabriel Heinz
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Livro")
public class Livro extends LivroBasico implements Serializable {

    @NotBlank(message = "O codigo de barra nao pode estar em branco")
    @Length(max = 20, message = "O codigo de barras nao pode ter mais q. {max} caracteres")
    @Column(name = "codigo_de_barras", length = 20, nullable = false)
    private String codigo_barras;
    @NotNull(message = "numro de paginas em branco!")
    @Column(name = "numero_paginas", length = 10, nullable = false)
    private Integer numero_paginas;
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Calendar data_cadastro;
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "idioma", referencedColumnName = "id", nullable = false)
    private Idioma idioma;
    @ManyToOne
    @JoinColumn(name = "formato", referencedColumnName = "id", nullable = false)
    private Formato formato;
    @ManyToOne
    @JoinColumn(name = "catalogo", referencedColumnName = "id", nullable = false)
    private Catalogo catalogo;

    public Livro() {
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    /**
     * @return the numero_paginas
     */
    public Integer getNumero_paginas() {
        return numero_paginas;
    }

    /**
     * @param numero_paginas the numero_paginas to set
     */
    public void setNumero_paginas(Integer numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the data_cadastro
     */
    public Calendar getData_cadastro() {
        return data_cadastro;
    }

    /**
     * @param data_cadastro the data_cadastro to set
     */
    public void setData_cadastro(Calendar data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the idioma
     */
    public Idioma getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the formato
     */
    public Formato getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    /**
     * @return the catalogo
     */
    public Catalogo getCatalogo() {
        return catalogo;
    }

    /**
     * @param catalogo the catalogo to set
     */
    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public String toString() {
        return "Livro{" + "codigo_barras=" + codigo_barras + ", numero_paginas=" + numero_paginas + ", ativo=" + ativo + ", data_cadastro=" + data_cadastro + ", valor=" + valor + ", idioma=" + idioma + ", formato=" + formato + ", catalogo=" + catalogo + '}';
    }
    
    
}
