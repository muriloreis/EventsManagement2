/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Murilo
 */
@Entity
@Table(name = "evento")
public class Event implements Serializable {
    private String [] atividade;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idevento")
    private int id;
    
    @Column()
    private String nome;
    private String descricao;
    
    @ManyToOne
    private User criador;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="evento_user", 
                joinColumns={@JoinColumn(name="evento_idevento")}, 
                inverseJoinColumns={@JoinColumn(name="inscritos_iduser")})
    private List<User> inscritos;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Activity> atividades = new ArrayList<>();
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the criador
     */
    public User getCriador() {
        return criador;
    }

    /**
     * @param criador the criador to set
     */
    public void setCriador(User criador) {
        this.criador = criador;
    }

    /**
     * @return the inscritos
     */
    public List<User> getInscritos() {
        return inscritos;
    }

    /**
     * @param inscritos the inscritos to set
     */
    public void setInscritos(List<User> inscritos) {
        this.inscritos = inscritos;
    }
    
    public void addInscritos(User user){
        inscritos.add(user);
    }

    /**
     * @return the atividades
     */
    public List<Activity> getAtividades() {
        return atividades;
    }

    /**
     * @param atividades the atividades to set
     */
    public void setAtividades(List<Activity> atividades) {
        this.atividades = atividades;
    }

    public void addAtividade(Activity activity) {
        atividades.add(activity);
    }
    
    /**
     * @return the atividade
     */
    public String[] getAtividade() {
        return atividade;
    }

    /**
     * @param atividade the atividade to set
     */
    public void setAtividade(String[] atividade) {
        this.atividade = atividade;
    }
    
}
