package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalho.model.bean.Cursos;
import trabalho.model.bean.Projetos;
import trabalho.model.conection.ConnectionFactory;
import trabalho.utils.InterfaceCRUDDAO;

public class CursosDAO implements InterfaceCRUDDAO<Cursos>{
	private Cursos curso = null;
	private String sql;
	private Connection con;
	private ConnectionFactory cf;
	private PreparedStatement st;
	
	@Override
	public void inserir(Cursos e) throws SQLException, ClassNotFoundException{
		this.sql = "insert into cursos(nome, descricao, qtdetemposaula, projeto) values(?,?,?,?)";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getNome());
		this.st.setString(2, e.getDescricao());
		this.st.setInt(3, e.getQtdeTemposAula());
		this.st.setInt(4, e.getProjeto().getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}
	
	@Override
	public void alterar(Cursos e)  throws SQLException, ClassNotFoundException{
		this.sql = "update cursos set nome = ?, descricao = ?, qtdetemposaula = ? where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getNome());
		this.st.setString(2, e.getDescricao());
		this.st.setInt(3, e.getQtdeTemposAula());
		this.st.setInt(4, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public void excluir(Cursos e)  throws SQLException, ClassNotFoundException{
		this.sql = "delete from cursos where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public ArrayList<Cursos> pesquisar()  throws SQLException, ClassNotFoundException{
		this.sql = "select * from cursos c";
		ArrayList<Cursos> cursos = new ArrayList<Cursos>();
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.curso = new Cursos(	
					rs.getInt("c.codigo"), 
					rs.getString("c.nome"),
					rs.getString("c.descricao"),
					rs.getInt("c.qtdetemposaula"),
					new ProjetosDAO().getItemByCodigo(new Projetos(rs.getInt("c.projeto")))
					);
			cursos.add(curso);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return cursos;
	}

	@Override
	public Cursos getItemByCodigo(Cursos e) throws SQLException, ClassNotFoundException {
		this.sql = "select * from cursos c where c.codigo = ?";
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.curso = new Cursos(	
					rs.getInt("c.codigo"), 
					rs.getString("c.nome"),
					rs.getString("c.descricao"),
					rs.getInt("c.qtdetemposaula"),
					new ProjetosDAO().getItemByCodigo(new Projetos(rs.getInt("c.projeto")))
					);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return this.curso;
	}
}