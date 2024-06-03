package br.com.fintech;

import br.com.fintech.dao.CategoriaDAO;
import br.com.fintech.dao.CategoriaDAOImpl;
import br.com.fintech.entities.Categoria;

import java.util.List;

public class TesteCategoria {
    public static void main(String[] args) {
    	cadastrarCategoria();
    	getAllCategorias();
    	editarCategoria();
    	getAllCategorias();
    	deletarCategoria();
        getAllCategorias();
       
    }

    public static void cadastrarCategoria() {
        try {
        	for(int i = 1; i <= 5; i++) {
        		 CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

                 Categoria categoria = new Categoria();
                 categoria.setId(i);
                 categoria.setNomeCategoria("Categoria " + i);
                 categoria.setDescricao("Categoria teste inserção pelo java");
                 categoriaDAO.insert(categoria);
        	}  
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editarCategoria() {
        try {
            int idEdit = 3;
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
            Categoria categoria = new Categoria();

            categoria.setNomeCategoria("Teste atualização de categoria");
            categoria.setDescricao("Teste atualização pelo java");
            categoriaDAO.update(idEdit, categoria);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletarCategoria() {
        try {
            int idEdit = 3;
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

            categoriaDAO.delete(idEdit);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllCategorias() {
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

            List<Categoria>  listCategoria = categoriaDAO.getAll();

            for (Categoria cat : listCategoria) {
                System.out.println(cat.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
