package br.com.fiap.store.dao.impl;
import br.com.fiap.store.bean.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {

	private Connection connection;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    String sql;

    @Override
    public void insert(Categoria categoria) throws SQLException {
        sql = "INSERT INTO T_CATEGORIA VALUES (?, ? , ?)";
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoria.getId());
            preparedStatement.setString(2, categoria.getNomeCategoria());
            preparedStatement.setString(3, categoria.getDescricao());
            preparedStatement.executeUpdate();
            System.out.println(("A categoria foi gravada!!"));

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            System.out.println(e);
           throw new SQLException("Erro ao cadastrar categoria", e);
        } finally {
        	connection.close();
        }

    }

    @Override
    public Categoria update(int id, Categoria categoria) throws SQLException {
        sql = "UPDATE T_CATEGORIA SET NM_CATEGORIA = ? , DES_CATEGORIA = ? WHERE CD_CATEGORIA = ?";
        try {
        	connection = FintechDB.getConnectionDB();

            preparedStatement = connection.prepareStatement(
                    sql
            );

            preparedStatement.setString(1, categoria.getNomeCategoria());
            preparedStatement.setString(2, categoria.getDescricao());
            preparedStatement.setInt(3, id);
            int rowCountResult = preparedStatement.executeUpdate();
            
            if(rowCountResult <= 0) {
            	throw new SQLException("Erro ao tentar editar o dado. "
            			+ "Nenhum dado foi atualizado, verifique as informações e tente novamente.");
            	
            } else {
            	  System.out.println(("A categoria foi atualizada!!"));
                  connection.commit();
            }
          
        }
        catch (Exception e) {
        	connection.rollback();
        	System.err.println(e);
        } finally {
        	connection.close();
        }

        
        return categoria;

    }

    @Override
    public void delete(int id) throws SQLException {
        sql = "DELETE T_CATEGORIA WHERE CD_CATEGORIA = ?";
        try {
        	connection = FintechDB.getConnectionDB();

            preparedStatement = connection.prepareStatement(
                    sql
            );

            preparedStatement.setInt(1, id);
            int rowCountResult = preparedStatement.executeUpdate();
            
            if(rowCountResult <= 0) {
            	throw new SQLException("Erro ao tentar deletar o dado. "
            			+ "Nenhum dado foi deletado, verifique as informações e tente novamente.");
            	
            } else {
            	 System.out.println(("A categoria foi deletada!!"));
                 connection.commit();
            }
           
        } catch (Exception e) {
        	connection.rollback();
        	System.err.println(e);
        } finally {
        	connection.close();
        }

    }

    @Override
    public List<Categoria> getAll() throws SQLException {
        List<Categoria> listCategorias = new ArrayList<Categoria>();
        sql = "SELECT * FROM T_CATEGORIA";
        try {
        	connection = FintechDB.getConnectionDB();

            statement  = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Categoria categoria = new Categoria(result.getInt("cd_categoria"),
                        result.getString("nm_categoria"), result.getString("des_categoria"));

                listCategorias.add(categoria);
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao cadastrar categoria", e);
        } finally {
        	connection.close();
        }


        return listCategorias;
    }
}
