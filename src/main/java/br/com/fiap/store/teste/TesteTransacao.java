package br.com.fintech;

import java.time.LocalDate;
import java.util.List;
import br.com.fintech.dao.TransacaoDAO;
import br.com.fintech.dao.TransacaoDAOImpl;
import br.com.fintech.entities.Categoria;
import br.com.fintech.entities.Transacao;
import br.com.fintech.entities.Usuario;
import br.com.fintech.enums.TipoTransacao;

public class TesteTransacao {
	public static void main(String[] args) {
        cadastrarTransacao();
        getAllTransacao();
        editarTransacao();
        getAllTransacao();
        deletarTransacao();
        getAllTransacao();
    }

    public static void cadastrarTransacao() {
        try {
        	for(int i = 1; i <= 5; i++) {
	            TransacaoDAO transacaoDAO = new TransacaoDAOImpl();
	            
	            Transacao transacao = new Transacao();
	            transacao.setId(i);
	            Usuario usuario = new Usuario ();
	            usuario.setId(1);
	            transacao.setUsuario(usuario);
	            transacao.setValTransacao(2200.0);
	            transacao.setDtLancamento(LocalDate.now());
	            transacao.setTipoTransacao(TipoTransacao.DESPESA);
	            Categoria categoria = new Categoria();
	            categoria.setId(1);
	            transacao.setCategoria(categoria);
	            
	            transacaoDAO.insert(transacao);
        	}
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void editarTransacao() {
        try {
            int idEdit = 3;
            TransacaoDAO transacaoDAO = new TransacaoDAOImpl();
            Transacao transacao = new Transacao();
            
            transacao.setId(20);
            Usuario usuario = new Usuario ();
            usuario.setId(1);
            transacao.setUsuario(usuario);
            transacao.setValTransacao(1100.0);
            transacao.setDtLancamento(LocalDate.now());
            transacao.setTipoTransacao(TipoTransacao.RECEITA);
            Categoria categoria = new Categoria(2,"Salário freela", "Teste1");
            transacao.setCategoria(categoria);
            transacaoDAO.update (idEdit, transacao);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletarTransacao() {
        try {
            int idEdit = 3;
            TransacaoDAO TransacaoDAO = new TransacaoDAOImpl();

            TransacaoDAO.delete(idEdit);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllTransacao() {
        try {
            TransacaoDAO TransacaoDAO = new TransacaoDAOImpl();

            List<Transacao>  listTransacao = TransacaoDAO.getAll();

            for (Transacao cat : listTransacao) {
                System.out.println(cat.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



