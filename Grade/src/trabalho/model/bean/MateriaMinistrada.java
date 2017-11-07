package trabalho.model.bean;

public class MateriaMinistrada {
	private int codigo;
	private Ministra ministra;
	private Turmas turma;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Ministra getMinistra() {
		return ministra;
	}
	public void setMinistra(Ministra ministra) {
		this.ministra = ministra;
	}
	public Turmas getTurma() {
		return turma;
	}
	public void setTurma(Turmas turma) {
		this.turma = turma;
	}
}