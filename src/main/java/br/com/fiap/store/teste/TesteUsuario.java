package br.com.fintech;

import java.time.LocalDate;
import java.util.List;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.dao.UsuarioDAOImpl;
import br.com.fintech.entities.Genero;
import br.com.fintech.entities.Usuario;

public class TesteUsuario {
	public static void main(String[] args) {
		insertUsuario();
		getAllUsuarios();
		editarUsuario();
		getAllUsuarios();
        deletarUsuario();
        getAllUsuarios();
	}
	
	public static void insertUsuario() {
        try {
        	for(int i = 1; i <= 5; i++) {
	            UsuarioDAO UsuarioDAO = new UsuarioDAOImpl();
	
	            Usuario usuario = new Usuario();
	            usuario.setId(i);
	            usuario.setNomeUsuario("Usuario " + i);                   
	            usuario.setDtNascimento(LocalDate.of(2001, 12,8));
	            Genero genero = new Genero();
	            genero.setId(2);
	            usuario.setGenero(genero);
	            usuario.setEmail("email" + i + "@gmail.com");
	            usuario.setSenha("1234");
	            UsuarioDAO.insert(usuario);
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
		
   public static void editarUsuario() {
        try {
            int idEdit = 3;
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            Usuario usuario = new Usuario();

            usuario.setEmail("teste@atualizacao.com");
            usuario.setNomeUsuario("Nome atualizado");
            usuarioDAO.update(idEdit, usuario);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void deletarUsuario() {
        try {
            int idEdit = 3;
            UsuarioDAO UsuarioDAO = new UsuarioDAOImpl();

            UsuarioDAO.delete(idEdit);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void getAllUsuarios() {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

            List<Usuario>  listUsuario = usuarioDAO.getAll();

            for (Usuario cat : listUsuario) {
                System.out.println(cat.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
