package streaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void salvarCliente(Cliente cliente) {

        String sql = "INSERT INTO cliente (id, nome, preferencia) VALUES (?, ?, ?)";

        try (Connection conexao = ConexaoPostgres.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getPreferencia());

            stmt.executeUpdate();

            System.out.println("Cliente salvo no PostgreSQL!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente:");
            e.printStackTrace();
        }
    }
}