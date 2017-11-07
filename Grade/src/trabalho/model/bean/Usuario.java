package trabalho.model.bean;

public class Usuario {
	private int codigo;
	private String nome;
	private String email;
	private String senha;
	private int estado;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Usuario(int codigo, String nome, String email, String senha, int estado) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.estado = estado;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}