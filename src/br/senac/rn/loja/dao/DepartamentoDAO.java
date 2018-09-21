package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.senac.rn.loja.model.Departamento;

public class DepartamentoDAO {

	public void inserir(Departamento departamento) {
		ConexaoDB db = new ConexaoDB();
		String sql = "INSERT INTO tb_departamentos (dep_nome, dep_sigla, dep_desconto) VALUES (?, ?, ?)";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			statement.setString(1, departamento.getNome());
			statement.setString(2, departamento.getSigla());
			statement.setFloat(3, departamento.getDesconto());
			statement.executeUpdate();
		} catch (SQLException exception) {}
		db.fechaConexao();
	}

	public void remover(Departamento departamento) {
		ConexaoDB db = new ConexaoDB();
		String sql = "DELETE FROM tb_departamentos WHERE dep_id = ?";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			statement.setInt(1, departamento.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {}
		db.fechaConexao();
	}

	public void editar(Departamento departamento) {
		ConexaoDB db = new ConexaoDB();
		String sql = "UPDATE tb_departamentos SET dep_nome = ?, dep_sigla = ?, dep_desconto = ? WHERE dep_id = ?";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			statement.setString(1, departamento.getNome());
			statement.setString(2, departamento.getSigla());
			statement.setFloat(3, departamento.getDesconto());
			statement.setInt(4, departamento.getId());
			statement.executeUpdate();
		} catch (SQLException exception) {}
		db.fechaConexao();
	}

	public List<Departamento> buscarTodos() {
		ConexaoDB db = new ConexaoDB();
		List<Departamento> departamentos = new ArrayList<Departamento>();
		String sql = "SELECT * FROM tb_departamentos";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(result.getInt("dep_id"));
				departamento.setNome(result.getString("dep_nome"));
				departamento.setSigla(result.getString("dep_sigla"));
				departamento.setDesconto(result.getFloat("dep_sigla"));
				departamentos.add(departamento);
			}
			db.fechaConexao();
			return departamentos;
		} catch (SQLException exception) {}
		db.fechaConexao();
		return null;
	}

	public Departamento buscarPorId(Integer id) {
		ConexaoDB db = new ConexaoDB();
		Departamento departamento = new Departamento();
		String sql = "SELECT * FROM tb_departamentos WHERE dep_id = ?";
		try {
			PreparedStatement statement = db.getConexao().prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				departamento.setId(result.getInt("dep_id"));
				departamento.setNome(result.getString("dep_nome"));
				departamento.setSigla(result.getString("dep_sigla"));
				departamento.setDesconto(result.getFloat("dep_desconto"));				
			}
			db.fechaConexao();
			return departamento;
		} catch (SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
		db.fechaConexao();
		return null;
	}

}
