package Controle;

import DAO.ManterNotasDAO;
import Modelo.ManterNotas;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManterNotasControle {

    public void gravar(ManterNotas x) throws SQLException {
        ManterNotasDAO dao = new ManterNotasDAO();
        try {
            if (x.getId() == null || x.getId() <= 0) {
                dao.gravar(x);
            } else {
                dao.alterar(x);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao salvar as informações: \n" + ex.getMessage());
        }
    }

    public void excluir(ManterNotas x) throws SQLException {
        if (JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este aluno?") == JOptionPane.YES_OPTION) {
            ManterNotasDAO dao = new ManterNotasDAO();
            dao.excluir(x);
        }

    }

    public void excluir(Long id) throws SQLException {
        if (JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este aluno?") == JOptionPane.YES_OPTION) {
            ManterNotasDAO dao = new ManterNotasDAO();
            dao.excluir(id);
        }
    }


    public void atualizarLista(JList listaManterNotas) throws SQLException{
        ManterNotasDAO dao = new ManterNotasDAO();
        List notas = dao.listarTodos();
        listaManterNotas.setListData(notas.toArray());        
    }

//    public Categoria getCategoriaPorId(Long id) throws SQLException {
//        CategoriaDAO dao = new CategoriaDAO();
//        Categoria c = (Categoria)dao.listarPorId(id);
//        return c;       
//    }
}
