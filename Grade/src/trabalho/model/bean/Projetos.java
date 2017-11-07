package trabalho.model.bean;

public class Projetos {
	private int codigo;
	private String titulo;
	private String descricao;
	private Usuario usuario;
	
	public Projetos() {
		super();
	}
	
	public Projetos(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Projetos(int codigo, String titulo, String descricao, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuario = usuario;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}