package br.com.fiap.store.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class InvestimentoTesouroDiretoSelic extends Investimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private double taxaSelicAnual;

    public InvestimentoTesouroDiretoSelic() {}

    public InvestimentoTesouroDiretoSelic(double taxaSelicAnual) {
        this.taxaSelicAnual = taxaSelicAnual;
    }

    public InvestimentoTesouroDiretoSelic(int id, double valorRetirado, LocalDate dtInvestimento, Banco banco, double taxaSelicAnual) {
        super(id, valorRetirado, dtInvestimento, banco);
        this.taxaSelicAnual = taxaSelicAnual;
    }

    public double getTaxaSelicAnual() {
        return taxaSelicAnual;
    }

    public void setTaxaSelicAnual(double taxaSelicAnual) {
        this.taxaSelicAnual = taxaSelicAnual;
    }


    public Double calcularRendimentoDiario() {
       return getValor() * (this.taxaSelicAnual / 100) / 252;
    }

    public Double calcularRendimentoAnual() {
        Double total = calcularRendimentoDiario() * 252;

        return total;
    }

    public void cadastrar() {
        System.out.println("Investimento Tesouro Direto Selic que possui foi criado." );
    }

}
