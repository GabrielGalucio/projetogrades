package trabalho.model.bean;

public class Materias {
	private int codigo;
	private String nome;
	private Projetos projeto;
	
	public Materias() {
		super();
	}
	public Materias(int codigo) {
		super();
		this.codigo = codigo;
	}
	public Materias(int codigo, String nome, Projetos projeto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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
	public Projetos getProjeto() {
		return projeto;
	}
	public void setProjeto(Projetos projeto) {
		this.projeto = projeto;
	}
}
