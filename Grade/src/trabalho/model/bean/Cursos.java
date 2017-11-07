package trabalho.model.bean;

public class Cursos {
	private int codigo;
	private String nome;
	private String descricao;
	private int qtdetemposaula;
	private Projetos projeto;
	
	public Cursos() {
		super();
	}

	public Cursos(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Cursos(int codigo, String nome, String descricao, int qtdetemposaula, Projetos projeto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdetemposaula = qtdetemposaula;
		this.projeto = projeto;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQtdeTemposAula() {
		return qtdetemposaula;
	}
	public void setQtdeTemposAula(int qtdetemposaula) {
		this.qtdetemposaula = qtdetemposaula;
	}
	public Projetos getProjeto() {
		return projeto;
	}
	public void setProjeto(Projetos projeto) {
		this.projeto = projeto;
	}
}