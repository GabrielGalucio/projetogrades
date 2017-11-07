package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalho.model.bean.Materias;
import trabalho.model.bean.Projetos;
import trabalho.model.conection.ConnectionFactory;
import trabalho.utils.InterfaceCRUDDAO;

public class MateriasDAO implements InterfaceCRUDDAO<Materias>{
	private Materias materia = null;
	private String sql;
	private Connection con;
	private ConnectionFactory cf;
	private PreparedStatement st;
	
	@Override
	public void inserir(Materias e) throws SQLException, ClassNotFoundException{
		this.sql = "insert into materias(nome, projeto) values(?,?)";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getNome());
		this.st.setInt(2, e.getProjeto().getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}
	
	@Override
	public void alterar(Materias e)  throws SQLException, ClassNotFoundException{
		this.sql = "update materias set nome = ? where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getNome());
		this.st.setInt(2, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public void excluir(Materias e)  throws SQLException, ClassNotFoundException{
		this.sql = "delete from materias where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public ArrayList<Materias> pesquisar()  throws SQLException, ClassNotFoundException{
		this.sql = "select * from materias m";
		ArrayList<Materias> materias = new ArrayList<Materias>();
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.materia = new Materias(	
					rs.getInt("m.codigo"),
					rs.getString("m.nome"),
					new ProjetosDAO().getItemByCodigo(new Projetos(rs.getInt("m.projeto")))
					);
			materias.add(materia);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return materias;
	}

	@Override
	public Materias getItemByCodigo(Materias e) throws SQLException, ClassNotFoundException {
		this.sql = "select * from materias m where m.codigo = ?";
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.materia = new Materias(	
					rs.getInt("m.codigo"),
					rs.getString("m.nome"),
					new ProjetosDAO().getItemByCodigo(new Projetos(rs.getInt("m.projeto")))
					);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return this.materia;
	}
}