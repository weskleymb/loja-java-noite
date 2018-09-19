package br.senac.rn.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.senac.rn.loja.model.Sexo;

public class SexoDAO {
	
	//MariaDB -> org.mariadb.jdbc.Driver
	//MySQL -> com.mysql.cj.jdbc.Driver
	//PostgreSQL -> org.postgresql.Driver
	//MSSQL -> com.microsoft.sqlserver.jdbc.SQLServerDriver

	private final String DRIVER = "org.mariadb.jdbc.Driver";
	private final String BANCO = "db_loja_manha";
	private final String URL = "jdbc:mariadb://localhost:3306/" + BANCO;
	private final String USUARIO = "root";
	private final String SENHA = "";
	
	private Connection getConexao() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			return connection;
		} catch (ClassNotFoundException exception) {
			System.out.println("DRIVER NAO ENCONTRADO!!!");
		} catch (SQLException exception) {
			System.out.println("PROBLEMAS COM A CONEXAO!!!");
		}
		return null;
	}
	
	public void inserir(Sexo sexo) {
		String sql = "INSERT INTO tb_sexos (sex_nome, sex_sigla) VALUES (?, ?)";
		try {
			PreparedStatement statement = getConexao().prepareStatement(sql);
			statement.setString(1, sexo.getNome());
			statement.setString(2, sexo.getSigla());
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("ERRO: " + exception.getMessage());
		}
	} 
	
	public void remover(Sexo sexo) {
		//to do
	}
	
	public void editar(Sexo sexo) {
		//to do
	}
	
	public List<Sexo> buscaTodos() {
		//to do
		return null;
	}
	
	public Sexo buscaPorId(Integer id) {
		//to do
		return null;
	}
	
}
