package br.com.fintech.dao;

import br.com.fintech.entities.Banco;
import java.sql.SQLException;
import java.util.List;

public interface BancoDAO {
	
    List<Banco> getAll() throws SQLException;

    void insert(Banco banco) throws SQLException;

    Banco update(int id, Banco banco) throws SQLException;

    void delete(int id) throws SQLException;
}

