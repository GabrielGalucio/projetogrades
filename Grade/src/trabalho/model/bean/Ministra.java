package trabalho.model.bean;

public class Ministra {
	private int codigo;
	private Materias materia;
	private Professores professor;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Materias getMateria() {
		return materia;
	}
	public void setMateria(Materias materia) {
		this.materia = materia;
	}
	public Professores getProfessor() {
		return professor;
	}
	public void setProfessor(Professores professor) {
		this.professor = professor;
	}
}