package br.com.fiap.store.bean;
import java.io.Serializable;
import java.time.LocalDate;

import br.com.fiap.store.enums.TipoTransacao;

public class Transacao extends Moeda implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private Double valTransacao;
    private LocalDate dtLancamento;
    private TipoTransacao tipoTransacao;
    private Categoria categoria;
    private Usuario usuario;

    public Transacao() {

    }

    public Transacao(int id, Double valTransacao, Usuario usuario, LocalDate dtLancamento, TipoTransacao tipoTransacao, Categoria categoria) {
        this.id = id;
        this.dtLancamento = dtLancamento;
        this.tipoTransacao = tipoTransacao;
        this.categoria = categoria;
        this.valTransacao = valTransacao;
        this.usuario = usuario;
        
    }

    public Transacao(int id, Double valTransacao, Usuario usuario, String descricao, LocalDate dtLancamento, TipoTransacao tipoTransacao, Categoria categoria) {
        this.id = id;
        this.dtLancamento = dtLancamento;
        this.tipoTransacao = tipoTransacao;
        this.categoria = categoria;
        this.valTransacao = valTransacao;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValTransacao() {
        return valTransacao;
    }

    public void setValTransacao(Double valTransacao) {
        this.valTransacao = valTransacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public LocalDate getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(LocalDate dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

	@Override
	public String toString() {
		return "Transacao [id =" + id + ", valTransacao =" + valTransacao + ", dtLancamento =" + dtLancamento
				+ ", tipoTransacao =" + tipoTransacao + ", categoria =" + categoria.getId() + ", usuario =" + usuario.getId() + "]";
	}
    
  
    }
