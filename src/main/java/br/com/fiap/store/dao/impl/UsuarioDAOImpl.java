package br.com.fintech.dao;
import br.com.fintech.connection.FintechDB;
import br.com.fintech.entities.Genero;
import br.com.fintech.entities.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection connection;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    String sql;
    
    
    @Override
    public void insert(Usuario Usuario) throws SQLException {
        sql = "INSERT INTO T_USUARIO VALUES (?,?,?,?,?,?)";
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Usuario.getId());
            preparedStatement.setString(2, Usuario.getNomeUsuario());
            preparedStatement.setInt(3, Usuario.getGenero().getId());
            Date date = Date.valueOf(Usuario.getDtNascimento());
            preparedStatement.setDate(4, date);
            preparedStatement.setString(5, Usuario.getEmail());
            preparedStatement.setString(6, Usuario.getSenha());
            preparedStatement.executeUpdate();

            System.out.println(("O usuário foi gravado!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
           throw new SQLException("Erro ao cadastrar usuário", e);
        } finally {
            connection.close();
        }

    }
    
    @Override
    public Usuario update(int id, Usuario Usuario) throws SQLException {
        sql = "UPDATE T_USUARIO SET NM_USUARIO = ?, EMAIL = ? WHERE CD_USUARIO = ?";
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(
                    sql
            );

            preparedStatement.setString(1, Usuario.getNomeUsuario());
            preparedStatement.setString(2, Usuario.getEmail());
            preparedStatement.setInt(3, id);
            
            int rowCountResult = preparedStatement.executeUpdate();
            
            if(rowCountResult <= 0) {
            	throw new SQLException("Erro ao tentar editar o usuario. "
            			+ "Nenhum usuario foi atualizado, verifique as informações e tente novamente.");
            	
            } else {
            	 System.out.println(("O usuário foi atualizado!!"));
                 connection.commit();
            }

           
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao editar usuário", e);
        } finally {
            connection.close();
        }

        return Usuario;

    }
    
    @Override
    public void delete(int id) throws SQLException {
        sql = "DELETE T_USUARIO WHERE CD_USUARIO = ?";
        try {
        	connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(
                    sql
            );

            preparedStatement.setInt(1, id);
            
            int rowCountResult = preparedStatement.executeUpdate();
            
            if(rowCountResult <= 0) {
            	throw new SQLException("Erro ao tentar deletar o usuario. "
            			+ "Nenhum usuario foi deletado, verifique as informações e tente novamente.");
            	
            } else {
            	 System.out.println(("O usuário foi atualizado!!"));
                 connection.commit();
            }
            

            System.out.println(("O usuário foi deletado!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao excluir usuário", e);
        } finally {
            connection.close();
        }
    }
    
    @Override
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        sql = "SELECT * FROM T_USUARIO";
        try {
        	connection = FintechDB.getConnectionDB();
            statement  = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
            	Genero genero = new Genero();
            	genero.setId(result.getInt("cd_genero"));
                Usuario usuario = new Usuario(result.getInt("cd_usuario"), result.getString("nm_usuario"),
                		result.getDate("dt_nascimento").toLocalDate(), genero,
                		result.getString("email"), result.getString("senha"));

                listUsuario.add(usuario);
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao cadastrar usuário", e);
        } finally {
            connection.close();
        }

        return listUsuario;
    }
}
