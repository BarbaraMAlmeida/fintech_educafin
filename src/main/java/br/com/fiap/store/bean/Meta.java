package br.com.fiap.store.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Meta extends Moeda implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String nomeMeta;
    private LocalDate dtFimMeta;
    private Usuario usuario;
    
    public Meta () {
    	
    }

    public Meta(int id, String nomeMeta, LocalDate dtFimMeta, Usuario usuario) {
		super();
		this.id = id;
		this.nomeMeta = nomeMeta;
		this.dtFimMeta = dtFimMeta;
		this.usuario = usuario;
	}

    public Meta( int id, String nomeMeta, LocalDate dtFimMeta, Double valor) {
        super(valor);
        this.id = id;
        this.nomeMeta = nomeMeta;
        this.dtFimMeta = dtFimMeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeMeta() {
        return nomeMeta;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public LocalDate getDtFimMeta() {
        return dtFimMeta;
    }

    public void setDtFimMeta(LocalDate dtFimMeta) {
        this.dtFimMeta = dtFimMeta;
    }
    
    public Usuario getUsuario() {
		return usuario;
	}
    
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Meta [id = " + id + ", nomeMeta = " + nomeMeta + ", dtFimMeta = " + dtFimMeta + ", usuario = " + usuario.getId() + "]";
	}
	
}
