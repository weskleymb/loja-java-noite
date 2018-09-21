package br.senac.rn.loja.teste;

import br.senac.rn.loja.dao.DepartamentoDAO;
import br.senac.rn.loja.dao.ProdutoDAO;
import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.model.Produto;

public class Teste {

	public static void main(String[] args) {

//		Departamento departamento = new DepartamentoDAO().buscarPorId(5);
//		
//		Produto produto = new Produto();
//		produto.setNome("Bola de Volei");
//		produto.setPreco(100f);
//		produto.setDepartamento(departamento);
		
		System.out.println(new ProdutoDAO().buscarTodos());
		
				
	}

}
