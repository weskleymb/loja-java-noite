package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.model.Produto;

public class ProdutoDAO {

	public void inserir(Produto produto) {
		ConexaoDB db = new ConexaoDB();
		String sql = "INSERT INTO tb_produtos (pro_nome, pro_preco, pro_dep_id) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = db.getConexao().prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setFloat(2, produto.getPreco());
			ps.setInt(3, produto.getDepartamento().getId());
			ps.executeUpdate();
		} catch (SQLException e) {}
		db.fechaConexao();
	}
	
	public List<Produto> buscarTodos() {
		ConexaoDB db = new ConexaoDB();
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT * FROM tb_produtos LEFT JOIN tb_departamentos ON dep_id = pro_dep_id";
		try {
			PreparedStatement ps = db.getConexao().prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Produto produto = new Produto();
				produto.setId(result.getInt("pro_id"));
				produto.setNome(result.getString("pro_nome"));
				produto.setPreco(result.getFloat("pro_preco"));
				produto.getDepartamento().setId(result.getInt("dep_id"));
				produto.getDepartamento().setNome(result.getString("dep_nome"));
				produto.getDepartamento().setSigla(result.getString("dep_sigla"));
				produto.getDepartamento().setDesconto(result.getFloat("dep_desconto"));
				produtos.add(produto);
			}
			db.fechaConexao();
			return produtos;
		} catch (SQLException e) {}
		db.fechaConexao();
		return null;
	}
	
	public Departamento buscarPorId(Integer id) {
		return null;
	}
	
}
