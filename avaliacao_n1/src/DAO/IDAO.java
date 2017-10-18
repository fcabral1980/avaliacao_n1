package DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO {

    public void gravar(Object o) throws SQLException;

    public void alterar(Object o) throws SQLException;

    public void excluir(Object o) throws SQLException;

    public void excluir(Long id) throws SQLException;

    public List listarTodos() throws SQLException;

//    public Object listarPorId(Long id) throws SQLException;
}
