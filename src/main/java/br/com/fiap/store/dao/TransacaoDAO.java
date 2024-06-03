package br.com.fintech.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fintech.entities.Transacao;

public interface TransacaoDAO {

	    void insert(Transacao transacao) throws SQLException;

	    Transacao update(int id, Transacao transacao) throws SQLException;

	    void delete(int id) throws SQLException;

	    List<Transacao> getAll() throws SQLException;
	}

