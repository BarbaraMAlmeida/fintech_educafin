package br.com.fiap.store.dao.impl;
import br.com.fiap.store.bean.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import br.com.fintech.entities.Banco;
import br.com.fintech.entities.Investimento;
import br.com.fintech.entities.InvestimentoCDBS;
import br.com.fintech.entities.Usuario;
import br.com.fintech.enums.TipoInvestimento;

public class InvestimentoDAOImpl implements InvestimentoDAO {

	private Connection connection;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    String sql;
	
	@Override
	public void calculateInvestimento(double valorInvestido) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void insert(Investimento investimento) throws SQLException {
		 sql = "INSERT INTO T_INVESTIMENTO (CD_INVESTIMENTO, ID_BANCO, CD_TIPO_INVESTIMENTO, CD_USUARIO, VAL_INVESTIDO, VAL_RETIRADO, DT_INVESTIMENTO, "
		 		+ "DT_VENCIMENTO) VALUES (?,?,?,?,?,?,?,?)";
	        try {
	        	connection = FintechDB.getConnectionDB();
	            preparedStatement = connection.prepareStatement(sql);

	            preparedStatement.setInt(1, investimento.getId());
	            preparedStatement.setInt(2, investimento.getBanco().getId());
	            preparedStatement.setInt(3, investimento.getTipoInvestimento().getCdTipoInvestimento());
	            preparedStatement.setInt(4, investimento.getUsuario().getId());
	            preparedStatement.setDouble(5, investimento.getValor());
	            preparedStatement.setDouble(6, investimento.getValorRetirado());
	            Date dateDtInvestimento = Date.valueOf(investimento.getDtInvestimento());
	            preparedStatement.setDate(7, dateDtInvestimento);
	            Date dateDtVencimento = Date.valueOf(investimento.getDtVencimento());
	            preparedStatement.setDate(8, dateDtVencimento);

	            
	            int rowCountResult = preparedStatement.executeUpdate();
	            
	            if(rowCountResult <= 0) {
	            	throw new SQLException("Erro ao tentar cadastrar o investimento. "
	            			+ "Nenhum investimento foi cadastrado, verifique as informações e tente novamente.");
	            	
	            } else {
	            	  System.out.println(("O investimento foi cadastrado!!"));
	                  connection.commit();
	            }
	          
	        }
	        catch (Exception e) {
	        	connection.rollback();
	        	System.err.println(e);
	        }finally {
	        	connection.close();
	        }
		
	}

	@Override
	public Investimento update(int id, Investimento investimento) throws SQLException {
		 sql = "UPDATE T_INVESTIMENTO SET ID_BANCO = ? , VAL_INVESTIDO = ?, VAL_RETIRADO = ?, DT_VENCIMENTO = ? WHERE CD_INVESTIMENTO = ?";
	        try {
	        	connection = FintechDB.getConnectionDB();
	            preparedStatement = connection.prepareStatement(sql);

	            preparedStatement.setInt(1, investimento.getBanco().getId());
	            preparedStatement.setDouble(2, investimento.getValor());
	            preparedStatement.setDouble(3, investimento.getValorRetirado());
	            Date date = Date.valueOf(investimento.getDtInvestimento());
	            preparedStatement.setDate(4, date);
	            preparedStatement.setInt(5, id);
	            
	            int rowCountResult = preparedStatement.executeUpdate();
	            
	            if(rowCountResult <= 0) {
	            	throw new SQLException("Erro ao tentar editar o investimento. "
	            			+ "Nenhum investimento foi atualizado, verifique as informações e tente novamente.");
	            	
	            } else {
	            	  System.out.println(("O investimento foi atualizado!!"));
	                  connection.commit();
	            }
	          
	        }
	        catch (Exception e) {
	        	connection.rollback();
	        	System.err.println(e);
	        }finally {
	        	connection.close();
	        }
	        
	        return investimento;	
	 }
	
	

	@Override
	public void delete(int id) throws SQLException {
		sql = "DELETE T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?";
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowCountResult = preparedStatement.executeUpdate();
            if(rowCountResult <= 0) {
            	throw new SQLException("Erro ao tentar deletar o investimento. "
            			+ "Nenhum investimento foi deletado, verifique as informações e tente novamente.");
            	
            } else {
            	 System.out.println(("O investimento foi deletado!!"));
                 connection.commit();
            }
           
        } catch (Exception e) {
        	connection.rollback();
        	System.err.println(e);
        }finally {
        	connection.close();
        }
		
	}
	
	  @Override
	    public List<Investimento> getAll() throws SQLException {
	        List<Investimento> listInvestimentos = new ArrayList<Investimento>();
	        sql = "SELECT * FROM T_INVESTIMENTO";
	        try {
	        	connection = FintechDB.getConnectionDB();
	            statement  = connection.createStatement();

	            ResultSet result = statement.executeQuery(sql);
	           

	            while (result.next()) {
	                Investimento investimento = new InvestimentoCDBS();
	                investimento.setId(result.getInt("cd_investimento"));	
	                Banco banco = new Banco();
	                banco.setId(result.getInt("id_banco"));
	                investimento.setBanco(banco);
	                Usuario usuario = new Usuario();
	                usuario.setId(result.getInt("cd_usuario"));
	                investimento.setUsuario(usuario);
	                int cdTipoInvestimento = result.getInt("cd_tipo_investimento");
	                investimento.setTipoInvestimento(TipoInvestimento.fromCdTipoInvestimento(cdTipoInvestimento));
	                investimento.setDtInvestimento(result.getDate("dt_investimento").toLocalDate());
	                investimento.setDtVencimento(result.getDate("dt_vencimento").toLocalDate());
	                investimento.setValorRetirado(result.getDouble("val_retirado"));
	                investimento.setValor(result.getDouble("val_investido"));
	                listInvestimentos.add(investimento);
	            }
	          
	            connection.commit();
	        } catch (SQLException e) {
	            connection.rollback();
	            throw new SQLException("Erro ao listar investimentos", e);
	        }finally {
	        	connection.close();
	        }

	        return listInvestimentos;
	    }

}
