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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Murilo
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="iduser")
    private int iduser;
    
    @Column(unique = true)
    private String username;
    
    @Column()
    private String nome;
    private String password;
    private String cpf;
    private UserType type;
    
    
    @OneToMany(mappedBy = "criador",targetEntity = Event.class,fetch = FetchType.EAGER)
    private List<Event> meusEventos;
    
    @ManyToMany(mappedBy = "inscritos",targetEntity = Event.class,fetch = FetchType.EAGER)
    private List<Event> minhasInscricoes;

    /**
     * @return the iduser
     */
    public int getIduser() {
        return iduser;
    }

    /**
     * @param iduser the iduser to set
     */
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the type
     */
    public UserType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(UserType type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the meusEventos
     */
    public List<Event> getMeusEventos() {
        return meusEventos;
    }

    /**
     * @param meusEventos the meusEventos to set
     */
    public void setMeusEventos(List<Event> meusEventos) {
        this.meusEventos = meusEventos;
    }

    /**
     * @return the minhasInscricoes
     */
    public List<Event> getMinhasInscricoes() {
        return minhasInscricoes;
    }

    /**
     * @param minhasInscricoes the minhasInscricoes to set
     */
    public void setMinhasInscricoes(List<Event> minhasInscricoes) {
        this.minhasInscricoes = minhasInscricoes;
    }
    
    public void addInscricao(Event event){
        minhasInscricoes.add(event);
    }
    
}
