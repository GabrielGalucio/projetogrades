package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalho.model.bean.Turno;
import trabalho.model.conection.ConnectionFactory;
import trabalho.utils.InterfaceCRUDDAO;

public class TurnoDAO implements InterfaceCRUDDAO<Turno>{
	private Turno turno = null;
	private String sql;
	private Connection con;
	private ConnectionFactory cf;
	private PreparedStatement st;
	
	@Override
	public void inserir(Turno e) throws SQLException, ClassNotFoundException{
		
	}
	
	@Override
	public void alterar(Turno e)  throws SQLException, ClassNotFoundException{
		
	}

	@Override
	public void excluir(Turno e)  throws SQLException, ClassNotFoundException{
		
	}

	@Override
	public ArrayList<Turno> pesquisar()  throws SQLException, ClassNotFoundException{
		this.sql = "select * from turno t";
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.turno = new Turno(
					rs.getInt("t.codigo"),
					rs.getString("t.descricao")
					);
			turnos.add(this.turno);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return turnos;
	}

	@Override
	public Turno getItemByCodigo(Turno e) throws SQLException, ClassNotFoundException {
		this.sql = "select * from turno t where t.codigo = ?";
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.turno = new Turno(
					rs.getInt("t.codigo"),
					rs.getString("t.descricao")
					);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return this.turno;
	}
}