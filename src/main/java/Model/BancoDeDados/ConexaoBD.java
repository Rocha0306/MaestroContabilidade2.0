package Model.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public Connection getConexao() {
        return Conexao;
    }



    private Connection Conexao;

    public void AbrirConexao() {
        try {
            Conexao = DriverManager.getConnection("jdbc:mysql://localhost/MAESTROCONTABILIDADE", "root", "Lorenzo05*");
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void FecharConexao() throws SQLException {
      Conexao.close();
    }
}



