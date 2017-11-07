package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalho.model.bean.Professores;
import trabalho.model.bean.Projetos;
import trabalho.model.conection.ConnectionFactory;
import trabalho.utils.InterfaceCRUDDAO;

public class ProfessoresDAO implements InterfaceCRUDDAO<Professores>{
	private Professores professor = null;
	private String sql;
	private Connection con;
	private ConnectionFactory cf;
	private PreparedStatement st;
	
	@Override
	public void inserir(Professores e) throws SQLException, ClassNotFoundException{
		this.sql = "insert into professores(nome, projeto) values(?,?)";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getNome());
		this.st.setInt(2, e.getProjeto().getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}
	
	@Override
	public void alterar(Professores e)  throws SQLException, ClassNotFoundException{
		this.sql = "update professores set nome = ? where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getNome());
		this.st.setInt(2, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public void excluir(Professores e)  throws SQLException, ClassNotFoundException{
		this.sql = "delete from professores where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public ArrayList<Professores> pesquisar()  throws SQLException, ClassNotFoundException{
		this.sql = "select * from professores p where p.codigo = ?";
		ArrayList<Professores> professores = new ArrayList<Professores>();
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.professor = new Professores(	
					rs.getInt("p.codigo"), 
					rs.getString("p.nome"),
					new ProjetosDAO().getItemByCodigo(new Projetos(rs.getInt("p.projeto")))
					);
			professores.add(professor);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return professores;
	}

	@Override
	public Professores getItemByCodigo(Professores e) throws SQLException, ClassNotFoundException {
		this.sql = "select * from professores p where p.codigo = ?";
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.professor = new Professores(	
					rs.getInt("p.codigo"), 
					rs.getString("p.nome"),
					new ProjetosDAO().getItemByCodigo(new Projetos(rs.getInt("p.projeto")))
					);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return this.professor;
	}
}