package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.connection.FintechDB;
import br.com.fintech.entities.Categoria;
import br.com.fintech.entities.Transacao;
import br.com.fintech.entities.Usuario;
import br.com.fintech.enums.TipoTransacao;

public class TransacaoDAOImpl implements TransacaoDAO {

    private Connection connection;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    String sql;

    @Override
    public void insert(Transacao transacao) throws SQLException {
    	  
    	sql = "INSERT INTO T_TRANSACAO (CD_TRANSACAO, CD_CATEGORIA, "
    			+ "CD_USUARIO, VAL_TRANSACAO, DT_LANCAMENTO, TIPO_TRANSACAO) VALUES (?,?,?,?,?,?)";
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, transacao.getId());
            preparedStatement.setInt(2, transacao.getCategoria().getId());
            preparedStatement.setInt(3,transacao.getUsuario().getId());
            preparedStatement.setDouble(4, 2200);
            Date date = Date.valueOf(transacao.getDtLancamento());
            preparedStatement.setDate(5, date);
            preparedStatement.setString(6, transacao.getTipoTransacao().name());
            preparedStatement.executeUpdate();

            System.out.println(("A Transação foi cadastrada!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
           throw new SQLException("Erro ao cadastrar transação", e);
        } finally {
            connection.close();
        }
    }

	@Override
	public Transacao update(int id, Transacao transacao) throws SQLException {
		sql = "UPDATE T_TRANSACAO SET CD_CATEGORIA = ?,VAL_TRANSACAO  = ?, "
				+ "DT_LANCAMENTO = ?, TIPO_TRANSACAO = ? WHERE CD_TRANSACAO = ?" ;
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(
                    sql
            );

    
            preparedStatement.setInt(1, transacao.getCategoria().getId());
            preparedStatement.setDouble(2, transacao.getValTransacao());
            Date date = Date.valueOf(transacao.getDtLancamento());
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, transacao.getTipoTransacao().name());
            preparedStatement.setInt(5,id);
            
            int rowCountResult = preparedStatement.executeUpdate();

            if(rowCountResult <= 0) {
            	throw new SQLException("Erro ao tentar atualizar a transaçao. "
            			+ "Nenhuma transaçao foi atualizada, verifique as informações e tente novamente.");
            	
            } else {
                System.out.println(("A Transação foi atualizada!!"));
                connection.commit();
            }
            
        
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao atualizar transação", e);
        } finally {
            connection.close();
        }

        return transacao;

    }

	@Override
	public void delete(int id) throws SQLException {
	        sql = "DELETE FROM T_TRANSACAO WHERE CD_TRANSACAO = ?";
	        try {
	        	connection = FintechDB.getConnectionDB();
	            preparedStatement = connection.prepareStatement(
	                    sql
	            );

	            preparedStatement.setInt(1, id);
	            int rowCountResult = preparedStatement.executeUpdate();

	            if(rowCountResult <= 0) {
	            	throw new SQLException("Erro ao tentar deletar a transaçao. "
	            			+ "Nenhuma transaçao foi deletada, verifique as informações e tente novamente.");
	            	
	            } else {
	                System.out.println(("A Transação foi deletada!!"));
	                connection.commit();
	            }
	            
	        } catch (SQLException e) {
	            connection.rollback();
	            throw new SQLException("Erro ao excluir transação", e);
	        } finally {
	            connection.close();
	        }
	    }

	@Override
	public List<Transacao> getAll() throws SQLException {
        List<Transacao> listTransacao = new ArrayList<Transacao>();
        sql = "SELECT * FROM T_TRANSACAO";
        try {
        	connection = FintechDB.getConnectionDB();
            statement  = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()) {
            	Usuario usuario = new Usuario();
            	usuario.setId(result.getInt("CD_USUARIO"));
            	Categoria categoria = new Categoria();
            	categoria.setId(result.getInt("CD_CATEGORIA"));
            	TipoTransacao tipoTransacao = TipoTransacao.valueOf(result.getString("TIPO_TRANSACAO"));
            	Transacao transacao = new Transacao(result.getInt("CD_TRANSACAO"), result.getDouble("VAL_TRANSACAO"), 
            			usuario, result.getDate("DT_LANCAMENTO").toLocalDate(), tipoTransacao, categoria);

                listTransacao.add(transacao);
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao cadastrar categoria", e);
        } finally {
            connection.close();
        }

        return listTransacao;
    }
	}
 
