package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    private static Connection conn;

    public static Connection getConexao() throws SQLException {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/avaliacao", "postgres", "12345678");
            }
            return conn;
        } catch (SQLException ex) {
            throw ex;
        }
    }

}
