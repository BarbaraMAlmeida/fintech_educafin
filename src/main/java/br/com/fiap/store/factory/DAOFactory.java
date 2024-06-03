package br.com.fiap.store.factory;

import br.com.fiap.store.dao.ProdutoDAO;
import br.com.fiap.store.dao.impl.OracleProdutoDAO;

public class DAOFactory {

	public static ProdutoDAO getProdutoDAO() {
		return new OracleProdutoDAO();
	}
	
}