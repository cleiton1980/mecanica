package br.com.mecanica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.mecanica.domain.Fabricante;
import br.com.mecanica.factory.ConexaoFactory;

public class FabricanteDAO {
	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into fabricante ");
		sql.append("(descricao) ");
		sql.append("values(?) ");
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());

		comando.executeUpdate();
	}// FIM DO METODO

	public void excluir(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from fabricante ");
		sql.append("where codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();

	}// FIM DO METODO

	public void editar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("update fabricante ");
		sql.append("set descricao =? ");
		sql.append("where codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();
	}

	public Fabricante buscarCodigo(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select codigo,descricao ");
		sql.append("from fabricante ");
		sql.append("where codigo = ? ");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		ResultSet resultado = comando.executeQuery();
		Fabricante retorno = null;
		if (resultado.next()) {
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		return retorno;
	}// FIM DO METODO

	public ArrayList<Fabricante> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select codigo,descricao ");
		sql.append("from fabricante ");
		sql.append("order by descricao asc ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		while (resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			lista.add(f);
		}
		return lista;
	}// FIM DO METODO

	public ArrayList<Fabricante> buscarDescricao(Fabricante f)
			throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select codigo,descricao ");
		sql.append("from fabricante ");
		sql.append("where descricao like ? ");
		sql.append("order by descricao asc ");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getDescricao() + "%");
		ResultSet resultado = comando.executeQuery();
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		while (resultado.next()) {
			Fabricante item = new Fabricante();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			lista.add(item);
		}
		return lista;
	}// FIM DO METODO

} // FIM DA CLASSE
