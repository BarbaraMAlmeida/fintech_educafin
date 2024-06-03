package br.com.fintech;

import br.com.fintech.dao.BancoDAO;
import br.com.fintech.dao.BancoDAOImpl;
import br.com.fintech.entities.Banco;


import java.util.List;

public class TesteBanco {

    public static void main(String[] args) {
    	cadastrarBanco();
    	getAllBancos();
    	editarBanco();
    	getAllBancos();
    	deletarBanco();
    	getAllBancos();
    }

    public static void cadastrarBanco() {
        try {
        	for(int i = 1; i <= 5; i++) {
            BancoDAO bancoDAO = new BancoDAOImpl();

            Banco banco = new Banco();
            banco.setId(i);
            banco.setCdBanco(i);
            banco.setNomeBanco("Banco " + i);
            bancoDAO.insert(banco);
            
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
      
    }


    public static void editarBanco() {
        try {
            int idEdit = 3;
            BancoDAO bancoDAO = new BancoDAOImpl();
            Banco banco = new Banco();

            banco.setCdBanco(1);
            banco.setNomeBanco("Banco do Brasil");
            bancoDAO.update(idEdit, banco);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletarBanco() {
        try {
            int idEdit = 3;
            BancoDAO bancoDAO = new BancoDAOImpl();

            bancoDAO.delete(idEdit);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllBancos() {
        try {
            BancoDAO bancoDAO = new BancoDAOImpl();

            List<Banco> listbancos = bancoDAO.getAll();

            for (Banco banco : listbancos) {
                System.out.println(banco.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
