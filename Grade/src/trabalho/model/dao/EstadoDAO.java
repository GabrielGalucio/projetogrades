package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalho.model.bean.Estado;
import trabalho.model.conection.ConnectionFactory;
import trabalho.utils.InterfaceCRUDDAO;

public class EstadoDAO implements InterfaceCRUDDAO<Estado>{
	private Estado estado = null;
	private String sql;
	private Connection con;
	private ConnectionFactory cf;
	private PreparedStatement st;
	
	@Override
	public void inserir(Estado e) throws SQLException, ClassNotFoundException{
		
	}
	
	@Override
	public void alterar(Estado e)  throws SQLException, ClassNotFoundException{
		
	}

	@Override
	public void excluir(Estado e)  throws SQLException, ClassNotFoundException{
		
	}

	@Override
	public ArrayList<Estado> pesquisar()  throws SQLException, ClassNotFoundException{
		this.sql = "select * from estado e";
		ArrayList<Estado> estados = new ArrayList<Estado>();
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.estado = new Estado(
					rs.getInt("e.codigo"),
					rs.getString("e.descricao")
					);
			estados.add(this.estado);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return estados;
	}

	@Override
	public Estado getItemByCodigo(Estado e) throws SQLException, ClassNotFoundException {
		this.sql = "select * from estado e where e.codigo = ?";
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			this.estado = new Estado(
					rs.getInt("e.codigo"),
					rs.getString("e.descricao")
					);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return this.estado;
	}
}