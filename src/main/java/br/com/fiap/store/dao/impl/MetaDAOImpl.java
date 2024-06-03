package br.com.fintech.dao;
import br.com.fintech.connection.FintechDB;
import br.com.fintech.entities.Meta;
import br.com.fintech.entities.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MetaDAOImpl implements MetaDAO {
	

    private Connection connection;
    String sql;
    Statement statement;
    PreparedStatement preparedStatement;

    
    @Override
    public void insert(Meta meta) throws SQLException {
        String sql = "INSERT INTO T_META (cd_meta, nm_meta, cd_usuario, val_meta, dt_fim_meta) VALUES (?, ?, ?, ?, ?)";
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, meta.getId());
            preparedStatement.setString(2, meta.getNomeMeta());
            preparedStatement.setInt(3, meta.getUsuario().getId());
            preparedStatement.setDouble(4, meta.getValor());
            Date date = Date.valueOf(meta.getDtFimMeta());
            preparedStatement.setDate(5, date);
            preparedStatement.executeUpdate();

            System.out.println("A meta foi gravada!!");
            connection.commit();
            
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar meta: " + e.getMessage());
            throw new SQLException("Erro ao cadastrar meta", e);
        }finally {
        	connection.close();
        }
    }

    @Override
    public Meta update(int id, Meta meta) throws SQLException {
        String sql = "UPDATE T_META SET NM_META = ?, DT_FIM_META = ? WHERE CD_META = ?";
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, meta.getNomeMeta());
            preparedStatement.setObject(2, meta.getDtFimMeta());
            preparedStatement.setInt(3, id);
            int rowCountResult = preparedStatement.executeUpdate();

            if(rowCountResult <= 0) {
            	throw new SQLException("Erro ao tentar atualizar a meta. "
            			+ "Nenhuma meta foi atualizada, verifique as informações e tente novamente.");
            	
            } else {
            	 System.out.println("A meta foi atualizada!!");
                 connection.commit();
            }
           
        } catch (SQLException e) {
            System.err.println("Erro ao editar meta: " + e.getMessage());
            throw new SQLException("Erro ao editar meta", e);
        }finally {
        	connection.close();
        }
        return meta;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM T_META WHERE CD_META = ?";
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowCountResult = preparedStatement.executeUpdate();

            if(rowCountResult <= 0) {
            	throw new SQLException("Erro ao tentar deletar a meta. "
            			+ "Nenhuma meta foi deletada, verifique as informações e tente novamente.");
            	
            } else {
            	  System.out.println("A meta foi deletada!!");
                  connection.commit();
            }
          
        } catch (SQLException e) {
            System.err.println("Erro ao excluir meta: " + e.getMessage());
            throw new SQLException("Erro ao excluir meta", e);
        }finally {
        	connection.close();
        }
    }

   @Override
    public List<Meta> getAll() throws SQLException {
        List<Meta> listMetas = new ArrayList<>();
        String sql = "SELECT * FROM T_META";
        try {
        	connection = FintechDB.getConnectionDB();
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()) {
            	Usuario usuario = new Usuario();
            	usuario.setId(result.getInt("cd_usuario"));
                Meta meta = new Meta();
                meta.setId(result.getInt("cd_meta"));
                meta.setNomeMeta(result.getString("nm_meta"));
                meta.setUsuario(usuario);
                meta.setValor(result.getDouble("val_meta"));
                meta.setDtFimMeta(result.getDate("dt_fim_meta").toLocalDate());
                listMetas.add(meta);
               
            }
            connection.commit();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar metas: " + e.getMessage());
            throw new SQLException("Erro ao buscar metas", e);
        }finally {
        	connection.close();
        }
        return listMetas;
    }
}
