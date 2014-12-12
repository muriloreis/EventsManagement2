/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;

/**
 *
 * @author Murilo
 */
@Entity
@Table(name = "atividade")
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idatividade")
    private int idatividade;
    
    @Column()
    private String nome;
    private String descricao;
    private int evento;

    /**
     * @return the idatividade
     */
    public int getIdatividade() {
        return idatividade;
    }

    /**
     * @param idatividade the idatividade to set
     */
    public void setIdatividade(int idatividade) {
        this.idatividade = idatividade;
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the evento
     */
    public int getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(int evento) {
        this.evento = evento;
    }
}
