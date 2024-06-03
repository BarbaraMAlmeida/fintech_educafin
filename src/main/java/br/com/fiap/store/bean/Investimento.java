package br.com.fiap.store.bean;

import java.io.Serializable;
import java.time.LocalDate;
import br.com.fiap.store.enums.TipoInvestimento;


public abstract class Investimento extends Moeda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
    private double valorRetirado;
    private LocalDate dtInvestimento;
    private Banco banco;
    private Usuario usuario;
    private LocalDate dtVencimento;
    private TipoInvestimento tipoInvestimento;


	public Investimento() {

    }
	

    public Investimento(int id, double valorRetirado, LocalDate dtInvestimento, Banco banco, Usuario usuario,
			LocalDate dtVencimento, TipoInvestimento tipoInvestimento, double valor) {
    	 super(valor);
		this.id = id;
		this.valorRetirado = valorRetirado;
		this.dtInvestimento = dtInvestimento;
		this.banco = banco;
		this.usuario = usuario;
		this.dtVencimento = dtVencimento;
		this.tipoInvestimento = tipoInvestimento;
	}


	public Investimento(int id, double valorRetirado, LocalDate dtInvestimento, Banco banco) {
        this.id = id;
        this.valorRetirado = valorRetirado;
        this.dtInvestimento = dtInvestimento;
        this.banco = banco;
    }

    public Investimento(Double valor, int id, double valorRetirado, LocalDate dtInvestimento, Banco banco) {
        super(valor);
        this.id = id;
        this.valorRetirado = valorRetirado;
        this.dtInvestimento = dtInvestimento;
        this.banco = banco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorRetirado() {
        return valorRetirado;
    }

    public void setValorRetirado(double valorRetirado) {
        this.valorRetirado = valorRetirado;
    }

    public LocalDate getDtInvestimento() {
        return dtInvestimento;
    }

    public void setDtInvestimento(LocalDate dtInvestimento) {
        this.dtInvestimento = dtInvestimento;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public LocalDate getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(LocalDate dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	
	public TipoInvestimento getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(TipoInvestimento tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

    
    @Override
	public String toString() {
		return "Investimento [id=" + id + ", valorRetirado=" + valorRetirado + ", dtInvestimento=" + dtInvestimento
				+ ", banco=" + banco.getId() + ", usuario=" + usuario.getId() + ", dtVencimento=" + dtVencimento + ", tipoInvestimento="
				+ tipoInvestimento.getCdTipoInvestimento() + "]";
	}
    
    
    
    


}
