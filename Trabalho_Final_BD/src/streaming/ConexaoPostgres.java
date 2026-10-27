package streaming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgres {

    private static final String URL = "jdbc:postgresql://localhost:5432/streaming";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do PostgreSQL não encontrado.", e);
        }

        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}