package br.com.fiap.store.bean;

import java.io.Serializable;

public abstract class Moeda implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private double valor;

    public Moeda() {

    }
    public Moeda(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
