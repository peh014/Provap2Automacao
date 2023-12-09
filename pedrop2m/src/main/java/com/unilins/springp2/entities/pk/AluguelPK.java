package com.unilins.springp2.entities.pk;

import java.util.Objects;

import com.unilins.springp2.entities.Carro;
import com.unilins.springp2.entities.Cliente;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AluguelPK {
	
	private static final long serialVersionUID = 1L;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Carro carro;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carro, cliente);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        AluguelPK that = (AluguelPK) obj;
        return Objects.equals(carro, that.carro) && Objects.equals(cliente, that.cliente);
    }
	
	
	
}
