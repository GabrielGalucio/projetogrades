package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalho.model.bean.Usuario;
import trabalho.model.conection.ConnectionFactory;
import trabalho.utils.InterfaceCRUDDAO;

public class UsuarioDAO implements InterfaceCRUDDAO<Usuario>{
	private String sql;
	private Connection con;
	private ConnectionFactory cf;
	private PreparedStatement st;
	
	@Override
	public void inserir(Usuario e) throws SQLException, ClassNotFoundException{
		this.sql = "insert into usuario(email, nome, senha, estado) values(?,?,?,?)";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getEmail());
		this.st.setString(2, e.getNome());
		this.st.setString(3, e.getSenha());
		this.st.setInt(4, e.getEstado());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}
	
	@Override
	public void alterar(Usuario e)  throws SQLException, ClassNotFoundException{
		this.sql = "update usuario set email = ?, nome = ?, senha = ? where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setString(1, e.getEmail());
		this.st.setString(2, e.getNome());
		this.st.setString(3, e.getSenha());
		this.st.setInt(4, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public void excluir(Usuario e)  throws SQLException, ClassNotFoundException{
		this.sql = "delete from usuario where codigo = ?";
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		this.st.execute();
		this.st.close();
		this.cf.closeConnection();
	}

	@Override
	public ArrayList<Usuario> pesquisar()  throws SQLException, ClassNotFoundException{
		
		return null;
	}

	@Override
	public Usuario getItemByCodigo(Usuario e) throws SQLException, ClassNotFoundException {
		this.sql = "select * from usuario u where u.codigo = ?";
		Usuario usuario = null;
		
		this.con = this.cf.getConnection();
		this.st = this.con.prepareStatement(sql);
		this.st.setInt(1, e.getCodigo());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			usuario = new Usuario(
					rs.getInt("u.codigo"), 
					rs.getString("u.email"),
					rs.getString("u.nome"),
					rs.getString("u.senha"),
					rs.getInt("u.estado")
					);
		}
		
		this.st.close();
		this.cf.closeConnection();
		
		return usuario;
	}
}