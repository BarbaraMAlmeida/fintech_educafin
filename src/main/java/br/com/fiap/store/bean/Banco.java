package br.com.fiap.store.bean;

import java.io.Serializable;

public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int idBanco;
    private int cdBanco;
    private String nmBanco;

 
    public Banco() {

    }

    public Banco(int id, int cdBanco, String nomeBanco) {
        this.idBanco = id;
        this.cdBanco = cdBanco;
        this.nmBanco = nomeBanco;
    }

    public int getId() {
        return idBanco;
    }

    public void setId(int id) {
        this.idBanco = id;
    }

    public int getCdBanco() {
        return cdBanco;
    }

    public void setCdBanco(int cdBanco) {
        this.cdBanco = cdBanco;
    }

    public String getNomeBanco() {
        return nmBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nmBanco = nomeBanco;
    }
    
    @Override
    public String toString() {
        return "Banco [" +
                "idBanco=" + idBanco +
                ", cdBanco=" + cdBanco +
                ", nmBanco='" + nmBanco + '\'' +
                ']';
    }


}
