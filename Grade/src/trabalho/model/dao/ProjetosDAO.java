package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalho.model.bean.Projetos;
import trabalho.model.bean.Usuario;
import trabalho.model.conection.ConnectionFactory;
import trabalho.utils.InterfaceCRUDDAO;

public class ProjetosDAO implements InterfaceCRUDDAO<Projetos>{
	private Projetos projeto = null;
	private String sql;
	private Connection con;
	private ConnectionFactory cf;
	private PreparedStatement st;
	
	@Override
	public void inserir(Projetos e) throws SQLException, ClassNotFoundException{
		this.sql = "insert into projetos(titulo, descricao, usuario) values(?,?,?)";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getTitulo());
		this.st.setString(2, e.getDescricao());
		this.st.setInt(3, e.getUsuario().getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}
	
	@Override
	public void alterar(Projetos e)  throws SQLException, ClassNotFoundException{
		this.sql = "update projetos set titulo = ?, descricao = ? where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getTitulo());
		this.st.setString(2, e.getDescricao());
		this.st.setInt(3, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public void excluir(Projetos e)  throws SQLException, ClassNotFoundException{
		this.sql = "delete from projetos where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public ArrayList<Projetos> pesquisar()  throws SQLException, ClassNotFoundException{
		this.sql = "select * from projetos p";
		ArrayList<Projetos> projetos = new ArrayList<Projetos>();
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.projeto = new Projetos(
					rs.getInt("p.codigo"), 
					rs.getString("p.titulo"),
					rs.getString("p.descricao"),
					new UsuarioDAO().getItemByCodigo(new Usuario(rs.getInt("p.usuario")))
					);
			projetos.add(projeto);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return projetos;
	}

	@Override
	public Projetos getItemByCodigo(Projetos e) throws SQLException, ClassNotFoundException {
		this.sql = "select * from projetos p where p.codigo = ?";
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.projeto = new Projetos(
					rs.getInt("p.codigo"), 
					rs.getString("p.titulo"),
					rs.getString("p.descricao"),
					new UsuarioDAO().getItemByCodigo(new Usuario(rs.getInt("p.usuario")))
					);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return this.projeto;
	}
}