package br.senac.rn.loja.teste;

import br.senac.rn.loja.dao.SexoDAO;

public class TestaArrayList {

	public static void main(String[] args) {

		SexoDAO dao = new SexoDAO();
		System.out.println(dao.buscaPorId(1));
				
	}

}
