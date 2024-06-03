package br.com.fiap.store.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String nomeUsuario;
    private LocalDate dtNascimento;
    private Genero genero;
    private String email;
    private String senha;

    public Usuario() {

    }

    public Usuario(int id, String nomeUsuario, LocalDate dtNascimento, Genero genero, String email, String senha) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.dtNascimento = dtNascimento;
        this.genero = genero;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomeUsuario=" + nomeUsuario + ", dtNascimento=" + dtNascimento + ", genero="
				+ genero + ", email=" + email + ", senha=" + senha + "]";
	}


}
