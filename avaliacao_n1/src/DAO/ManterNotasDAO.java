package DAO;

import Modelo.ManterNotas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManterNotasDAO implements IDAO {

    @Override
    public void gravar(Object o) throws SQLException {
        ManterNotas x = (ManterNotas) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "INSERT INTO public.aluno(\n"
                    + "	nome, nota1, nota2, nota3, nota4)\n"
                    + "	VALUES (?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, x.getNome());
            stmt.setInt(2, x.getNota1());
            stmt.setInt(3, x.getNota2());
            stmt.setInt(4, x.getNota3());
            stmt.setInt(5, x.getNota4());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar cadastrar o aluno. \n" + e.getMessage());
        }
    }

    @Override
    public void alterar(Object o) throws SQLException {
        ManterNotas x = (ManterNotas) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "UPDATE public.aluno\n"
                    + "	SET nome=?, nota1=?, nota2=?, nota3=?, nota4=?\n"
                    + "	WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores       

            stmt.setString(1, x.getNome());
            stmt.setInt(2, x.getNota1());
            stmt.setInt(3, x.getNota2());
            stmt.setInt(4, x.getNota3());
            stmt.setInt(5, x.getNota4());
            stmt.setLong(6, x.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar alterar os dados do aluno. \n" + e.getMessage());
        }
    }

    @Override
    public void excluir(Object o) throws SQLException {
        ManterNotas x = (ManterNotas) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.aluno\n"
                    + "	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setLong(1, x.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover o aluno. \n" + e.getMessage());
        }
    }

    @Override
    public void excluir(Long id) throws SQLException {

        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.aluno\n"
                    + "	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setLong(1, id);

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover o aluno. \n" + e.getMessage());
        }
    }

    @Override
    public List listarTodos() throws SQLException {
        List lista = new ArrayList();
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "select * from aluno";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ManterNotas x = new ManterNotas(rs.getString("nome"));
                x.setNota1(Integer.parseInt(rs.getString("nota1")));
                x.setNota2(Integer.parseInt(rs.getString("nota2")));
                x.setNota3(Integer.parseInt(rs.getString("nota3")));
                x.setNota4(Integer.parseInt(rs.getString("nota4")));              
                x.setId(rs.getInt("id"));
                lista.add(x);
            }

            rs.close();
            stmt.close();
            conn.close();
            return lista;
        } catch (SQLException e) {
            throw new SQLException("Erro ao recuperar a lista de aluno. \n" + e.getMessage());
        }

//        List lista = new ArrayList();
//        Connection conn = null;
//        try {
//            conn = FabricaConexao.getConexao();
//            String sql = "SELECT id, nome, nota1, nota2, nota3, nota4, media, situacao\n"
//                    + "	FROM public.aluno;";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                ManterNotas x = (ManterNotas);
//                x.setId(rs.getLong("id"));
//                x.setNome(rs.getString("nome"));
//                x.set x
//                .setDescricao(rs.getString("descricao"));
//
//                lista.add(c);
//            }
//
//            rs.close();
//            stmt.close();
//
//            return lista;
//        } catch (SQLException e) {
//            throw new SQLException("Eroo ao recuperar a lista de categorias. \n" + e.getMessage());
//        }
    }

//    @Override
//    public Object listarPorId(Long id) throws SQLException {
//        Connection conn = null;
//        try {
//            conn = FabricaConexao.getConexao();
//            String sql = "SELECT id, nome, descricao\n" +
//"	FROM public.categoria WHERE id=?;";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setLong(1, id);
//            ResultSet rs = stmt.executeQuery();
//            rs.next();
//            Categoria c = new Categoria();
//            c.setNome(rs.getString("nome"));
//            c.setDescricao(rs.getString("descricao"));
//            c.setId(rs.getLong("id"));
//            
//
//            rs.close();
//            stmt.close();
//            
//            return c;
//        } catch (SQLException e) {
//            throw new SQLException("Eroo ao recuperar a categoria. \n" + e.getMessage());
//        }
//    }
}
