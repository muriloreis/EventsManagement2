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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Murilo
 */
@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {
    private int eventoId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column
    private double quantia;
    private FormaPagamento tipo;
    
    @ManyToOne
    private User cliente;
    
    @ManyToOne
    private Event recebedor;

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
     * @return the quantia
     */
    public double getQuantia() {
        return quantia;
    }

    /**
     * @param quantia the quantia to set
     */
    public void setQuantia(double quantia) {
        this.quantia = quantia;
    }

    /**
     * @return the tipo
     */
    public FormaPagamento getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(FormaPagamento tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cliente
     */
    public User getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the recebedor
     */
    public Event getRecebedor() {
        return recebedor;
    }

    /**
     * @param recebedor the recebedor to set
     */
    public void setRecebedor(Event recebedor) {
        this.recebedor = recebedor;
    }

    /**
     * @return the eventoId
     */
    public int getEventoId() {
        return eventoId;
    }

    /**
     * @param eventoId the eventoId to set
     */
    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
