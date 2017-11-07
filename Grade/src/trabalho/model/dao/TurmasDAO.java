package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalho.model.bean.Cursos;
import trabalho.model.bean.Turmas;
import trabalho.model.bean.Turno;
import trabalho.model.conection.ConnectionFactory;
import trabalho.utils.InterfaceCRUDDAO;

public class TurmasDAO implements InterfaceCRUDDAO<Turmas>{
	private Turmas turma = null;
	private String sql;
	private Connection con;
	private ConnectionFactory cf;
	private PreparedStatement st;
	
	@Override
	public void inserir(Turmas e) throws SQLException, ClassNotFoundException{
		this.sql = "insert into turmas(nome, abreviacao, turno, curso) values(?,?,?,?)";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getNome());
		this.st.setString(2, e.getAbreviacao());
		this.st.setInt(3, e.getTurno().getCodigo());
		this.st.setInt(4, e.getCurso().getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}
	
	@Override
	public void alterar(Turmas e)  throws SQLException, ClassNotFoundException{
		this.sql = "update turmas set nome = ?, abreviacao = ?, turno = ? where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getNome());
		this.st.setString(2, e.getAbreviacao());
		this.st.setInt(3, e.getTurno().getCodigo());
		this.st.setInt(4, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public void excluir(Turmas e)  throws SQLException, ClassNotFoundException{
		this.sql = "delete from turmas where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public ArrayList<Turmas> pesquisar()  throws SQLException, ClassNotFoundException{
		this.sql = "select * from turmas t where t.codigo = ?";
		ArrayList<Turmas> turmas = new ArrayList<Turmas>();
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.turma = new Turmas(
					rs.getInt("t.codigo"),
					rs.getString("t.nome"),
					rs.getString("t.abreviacao"),
					new TurnoDAO().getItemByCodigo(new Turno(rs.getInt("t.turno"))),
					new CursosDAO().getItemByCodigo(new Cursos(rs.getInt("t.curso")))
					);
			turmas.add(turma);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return turmas;
	}

	@Override
	public Turmas getItemByCodigo(Turmas e) throws SQLException, ClassNotFoundException {
		this.sql = "select * from turmas t where t.codigo = ?";
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		st.setInt(1, e.getCodigo());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.turma = new Turmas(
					rs.getInt("t.codigo"),
					rs.getString("t.nome"),
					rs.getString("t.abreviacao"),
					new TurnoDAO().getItemByCodigo(new Turno(rs.getInt("t.turno"))),
					new CursosDAO().getItemByCodigo(new Cursos(rs.getInt("t.curso")))
					);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return this.turma;
	}
}