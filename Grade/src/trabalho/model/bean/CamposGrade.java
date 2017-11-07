package trabalho.model.bean;

public class CamposGrade {
	private int codigo;
	private Turmas turma;
	private int tempoaula;
	private DiasAulas diaaula;
	private MateriaMinistrada materiaministrada;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Turmas getTurma() {
		return turma;
	}
	public void setTurma(Turmas turma) {
		this.turma = turma;
	}
	public int getTempoaula() {
		return tempoaula;
	}
	public void setTempoaula(int tempoaula) {
		this.tempoaula = tempoaula;
	}
	public DiasAulas getDiaaula() {
		return diaaula;
	}
	public void setDiaaula(DiasAulas diaaula) {
		this.diaaula = diaaula;
	}
	public MateriaMinistrada getMateriaministrada() {
		return materiaministrada;
	}
	public void setMateriaministrada(MateriaMinistrada materiaministrada) {
		this.materiaministrada = materiaministrada;
	}
}