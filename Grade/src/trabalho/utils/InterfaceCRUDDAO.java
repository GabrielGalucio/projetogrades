package trabalho.utils;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceCRUDDAO<E> {
	public void inserir(E e) throws SQLException, ClassNotFoundException;
	public void alterar(E e) throws SQLException, ClassNotFoundException;
	public void excluir(E e) throws SQLException, ClassNotFoundException;
	public ArrayList<E> pesquisar() throws SQLException, ClassNotFoundException;
	public E getItemByCodigo(E e) throws SQLException, ClassNotFoundException;
}