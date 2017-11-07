package trabalho.model.bean;

public class DiasSemana {
	private int codigo;
	private String descricao;
	
	public DiasSemana() {
		super();
	}
	public DiasSemana(int codigo) {
		super();
		this.codigo = codigo;
	}
	public DiasSemana(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}