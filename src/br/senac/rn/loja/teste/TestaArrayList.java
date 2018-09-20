package br.senac.rn.loja.teste;

import br.senac.rn.loja.dao.DepartamentoDAO;
import br.senac.rn.loja.dao.SexoDAO;
import br.senac.rn.loja.model.Departamento;

public class TestaArrayList {

	public static void main(String[] args) {

		SexoDAO dao = new SexoDAO();
		System.out.println(dao.buscaTodos());
		
		DepartamentoDAO depDao = new DepartamentoDAO();
		depDao.inserir(new Departamento());
				
	}

}
