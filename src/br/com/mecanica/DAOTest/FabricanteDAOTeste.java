package br.com.mecanica.DAOTest;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mecanica.dao.FabricanteDAO;
import br.com.mecanica.domain.Fabricante;

public class FabricanteDAOTeste {

	@Test
	@Ignore
	public void salvar() throws SQLException {
		Fabricante f = new Fabricante();
		f.setDescricao("SANTA CRUZ LTDA");

		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f);
	}
	@Test
	@Ignore
	public void editar() throws SQLException {
		Fabricante f = new Fabricante();
		f.setCodigo(1L);
		f.setDescricao("PHIZER");

		FabricanteDAO dao = new FabricanteDAO();
		dao.editar(f);

	}
	@Test
	@Ignore
	public void excluir()throws SQLException{
		Fabricante f = new Fabricante();
		f.setCodigo(1l);
		FabricanteDAO dao = new FabricanteDAO();
		dao.excluir(f);
	}
	public void listar()throws SQLException{
		FabricanteDAO dao = new FabricanteDAO();
	}
}
