package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalho.model.bean.DiasSemana;
import trabalho.model.conection.ConnectionFactory;
import trabalho.utils.InterfaceCRUDDAO;

public class DiasSemanaDAO implements InterfaceCRUDDAO<DiasSemana>{
	private String sql;
	private Connection con;
	private ConnectionFactory cf;
	private PreparedStatement st;
	
	@Override
	public void inserir(DiasSemana e) throws SQLException, ClassNotFoundException{
		
	}
	
	@Override
	public void alterar(DiasSemana e)  throws SQLException, ClassNotFoundException{
		
	}

	@Override
	public void excluir(DiasSemana e)  throws SQLException, ClassNotFoundException{
		
	}

	@Override
	public ArrayList<DiasSemana> pesquisar()  throws SQLException, ClassNotFoundException{
		this.sql = "select * from diassemana";
		ArrayList<DiasSemana> diassemana = new ArrayList<DiasSemana>();
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			DiasSemana diaSemana = new DiasSemana();
			diaSemana.setCodigo(rs.getInt(1));
			diaSemana.setDescricao(rs.getString(2));
			diassemana.add(diaSemana);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return diassemana;
	}
}