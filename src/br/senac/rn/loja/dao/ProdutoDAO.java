package br.senac.rn.loja.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
