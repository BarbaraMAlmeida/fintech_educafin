package br.com.fintech.dao;
import java.sql.SQLException;
import java.util.List;

import br.com.fintech.entities.Meta;

public interface MetaDAO {
    
	void insert(Meta meta) throws SQLException;
    
    Meta update(int id, Meta meta) throws SQLException;
    
    void delete(int id) throws SQLException;
    
    List<Meta> getAll() throws SQLException;
}
