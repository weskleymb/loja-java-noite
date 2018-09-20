package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.senac.rn.loja.model.Sexo;

public class SexoDAO {
	
	public void inserir(Sexo sexo) {
		ConexaoDB db = new ConexaoDB();
		String sql = "INSERT INTO tb_sexos (sex_nome, sex_sigla) VALUES (?, ?)";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			statement.setString(1, sexo.getNome());
			statement.setString(2, sexo.getSigla());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		db.fechaConexao();
	} 
	
	public void remover(Sexo sexo) {
		ConexaoDB db = new ConexaoDB();
		String sql = "DELETE FROM tb_sexos WHERE sex_id = ?";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			statement.setInt(1, sexo.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		db.fechaConexao();
	}
	
	public void editar(Sexo sexo) {
		ConexaoDB db = new ConexaoDB();
		String sql = "UPDATE tb_sexos SET sex_nome = ?, sex_sigla = ? WHERE sex_id = ?";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			statement.setString(1, sexo.getNome());
			statement.setString(2, sexo.getSigla());
			statement.setInt(3, sexo.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		db.fechaConexao();
	}
	
	public List<Sexo> buscaTodos() {
		ConexaoDB db = new ConexaoDB();
		List<Sexo> sexos = new ArrayList<Sexo>();
		String sql = "SELECT * FROM tb_sexos";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Sexo sexo = new Sexo();
				sexo.setId(result.getInt("sex_id"));
				sexo.setNome(result.getString("sex_nome"));
				sexo.setSigla(result.getString("sex_sigla"));
				sexos.add(sexo);
			}
			db.fechaConexao();
			return sexos;
		} catch (SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		db.fechaConexao();
		return null;
	}
	
	public Sexo buscaPorId(Integer id) {
		ConexaoDB db = new ConexaoDB();
		Sexo sexo = new Sexo();
		String sql = "SELECT * FROM tb_sexos WHERE sex_id = ?";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				sexo.setId(result.getInt("sex_id"));
				sexo.setNome(result.getString("sex_nome"));
				sexo.setSigla(result.getString("sex_sigla"));				
			}
			db.fechaConexao();
			return sexo;
		} catch (SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		db.fechaConexao();
		return null;
	}
	
}
