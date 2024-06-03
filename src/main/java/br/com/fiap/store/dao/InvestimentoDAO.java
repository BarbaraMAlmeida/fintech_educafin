package br.com.fintech.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fintech.entities.Categoria;
import br.com.fintech.entities.Investimento;

public interface InvestimentoDAO {
	
	void calculateInvestimento(double valorInvestido);
	
	Investimento update(int id, Investimento investimento) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	void insert(Investimento investimento) throws SQLException;
	
    List<Investimento> getAll() throws SQLException;
}
