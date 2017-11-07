package trabalho.model.bean;

public class Turmas {
	private int codigo;
	private String nome;
	private String abreviacao;
	private Turno turno;
	private Cursos curso;
	
	public Turmas() {
		super();
	}

	public Turmas(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Turmas(int codigo, String nome, String abreviacao, Turno turno, Cursos curso) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.abreviacao = abreviacao;
		this.turno = turno;
		this.curso = curso;
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
	public String getAbreviacao() {
		return abreviacao;
	}
	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public Cursos getCurso() {
		return curso;
	}
	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
}
