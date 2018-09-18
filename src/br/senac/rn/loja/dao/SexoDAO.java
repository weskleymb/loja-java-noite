package br.senac.rn.loja.dao;

import java.util.ArrayList;
import java.util.List;

import br.senac.rn.loja.model.Sexo;

public class SexoDAO {

	private static List<Sexo> sexos = new ArrayList<Sexo>();
	
	public void inserir(Sexo sexo) {
		sexos.add(sexo);
	}
	
	public void remover(Sexo sexo) {
		sexos.remove(sexo);
	}
	
	public void editar(Sexo sexo) {
		int indice = sexos.indexOf(sexo);
		sexos.set(indice, sexo);
	}
	
	public List<Sexo> buscaTodos() {
		return sexos;
	}
	
	public Sexo buscaPorId(Integer id) {
		Sexo sexo = new Sexo();
		sexo.setId(id);
		int indice = sexos.indexOf(sexo);
		return sexos.get(indice);
	}
	
	public Sexo buscaPorNome(String nome) {
		for (Sexo sexo : sexos) {
			if (sexo.getNome().equals(nome)) {
				return sexo;
			}
		}
		return null;
	}
	
	public Sexo buscaPorSigla(String sigla) {
		for (Sexo sexo : sexos) {
			if (sexo.getSigla().equals(sigla)) {
				return sexo;
			}
		}
		return null;
	}
	
}
