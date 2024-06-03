package br.com.fintech.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fintech.entities.Usuario;

public interface UsuarioDAO {
	
	void insert(Usuario Usario) throws SQLException;

    Usuario update(int id, Usuario Usuario) throws SQLException;

    void delete(int id) throws SQLException;

    List<Usuario> getAll() throws SQLException;

}
