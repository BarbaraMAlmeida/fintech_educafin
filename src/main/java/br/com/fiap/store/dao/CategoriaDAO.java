package br.com.fintech.dao;

import br.com.fintech.entities.Categoria;

import java.sql.SQLException;
import java.util.List;

public interface CategoriaDAO {

    void insert(Categoria categoria) throws SQLException;

    Categoria update(int id, Categoria categoria) throws SQLException;

    void delete(int id) throws SQLException;

    List<Categoria> getAll() throws SQLException;
}
