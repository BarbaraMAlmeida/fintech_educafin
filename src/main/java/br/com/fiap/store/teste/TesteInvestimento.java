package br.com.fintech;

import java.time.LocalDate;
import java.util.List;
import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.dao.InvestimentoDAOImpl;
import br.com.fintech.entities.Banco;
import br.com.fintech.entities.Investimento;
import br.com.fintech.entities.InvestimentoCDBS;
import br.com.fintech.entities.Usuario;
import br.com.fintech.enums.TipoInvestimento;

public class TesteInvestimento {

	 public static void main(String[] args) {
		 	cadastrarInvestimento();
		 	getAllInvestimentos();
	        editarInvestimento();
	        getAllInvestimentos();
	        deletarInvestimento();
	        getAllInvestimentos();
	    }

	 public static void cadastrarInvestimento() {
	        try {
	        	for(int i = 1; i <= 5; i++) {
		            InvestimentoDAO investimentoDAO = new InvestimentoDAOImpl();
	
		            Investimento investimento = new InvestimentoCDBS();
		            investimento.setId(i);
		            Banco banco = new Banco();
		            banco.setId(1);
		            investimento.setBanco(banco);
		            investimento.setTipoInvestimento(TipoInvestimento.CDBS);
		            Usuario usuario = new Usuario();
		            usuario.setId(1);
		            investimento.setUsuario(usuario);
		            investimento.setValor(3000.0);
		            investimento.setValorRetirado(13000.0);
		            investimento.setDtInvestimento(LocalDate.now());
		            investimento.setDtVencimento(LocalDate.of(2026, 8, 10));
		            investimentoDAO.insert(investimento);
	        	}
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void editarInvestimento() {
	        try {
	            int idEdit = 3;
	            InvestimentoDAO investimentoDAO = new InvestimentoDAOImpl();
	            Investimento investimento = new InvestimentoCDBS();
	            Banco banco = new Banco();
	            banco.setId(2);
	            investimento.setBanco(banco);
	            investimento.setDtInvestimento(LocalDate.now());
	            investimento.setValor(1400.0);
	            investimento.setValorRetirado(55000.0);
	            
	            investimentoDAO.update(idEdit, investimento);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void deletarInvestimento() {
	        try {
	            int idEdit = 3;
	            InvestimentoDAO investimentoDAO = new InvestimentoDAOImpl();

	            investimentoDAO.delete(idEdit);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void getAllInvestimentos() {
	        try {
	            InvestimentoDAO investimentoDAO = new InvestimentoDAOImpl();

	            List<Investimento>  listInvestimento = investimentoDAO.getAll();
	           
	            for (Investimento inv : listInvestimento) {
	                System.out.println(inv.toString());
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
}
