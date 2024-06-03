package br.com.fiap.store.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class InvestimentoCDBS extends Investimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private double taxaCdi;
    private double percentualCdi;

    public InvestimentoCDBS() {

    }

    public InvestimentoCDBS(double taxaCdi, double percentualCdi) {
        this.taxaCdi = taxaCdi;
        this.percentualCdi = percentualCdi;
    }

    public InvestimentoCDBS(int id, double valorRetirado, LocalDate dtInvestimento, Banco banco, double taxaCdi, double percentualCdi) {
        super(id, valorRetirado, dtInvestimento, banco);
        this.taxaCdi = taxaCdi;
        this.percentualCdi = percentualCdi;
    }

    public InvestimentoCDBS(int id, Double valor, double valorRetirado, LocalDate dtInvestimento, Banco banco, double taxaCdi, double percentualCdi) {
        super(valor, id, valorRetirado, dtInvestimento, banco);
        this.taxaCdi = taxaCdi;
        this.percentualCdi = percentualCdi;

    }

    public double getTaxaCdi() {
        return taxaCdi;
    }

    public void setTaxaCdi(double taxaCdi) {
        this.taxaCdi = taxaCdi;
    }

    public double getPercentualCdi() {
        return percentualCdi;
    }

    public void setPercentualCdi(double percentualCdi) {
        this.percentualCdi = percentualCdi;
    }

    public Integer calcularDiasInvestimento() {
        Integer dias =  getDtVencimento().getDayOfMonth() - getDtInvestimento().getDayOfMonth();
        return dias;
    }

  
    public void cadastrar() {
        System.out.println("Investimento CDBS foi criado." );
    }


}
