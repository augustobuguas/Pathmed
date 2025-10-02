package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    private static final String USER = "RM563858";

    private static final String PASSWORD = "100605";

    public static Connection getConnection() {

        Connection conn = null;

        try {
            // O driver ojdbc17 que você adicionou é carregado automaticamente pelo Java
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida!");

            // Se você não tem o método createTable pronto, comente esta linha por enquanto:
            // createTable(conn);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados! Verifique URL, Usuário e Senha.");
            e.printStackTrace();
        }
        return conn;
    }

    // Método main para testar a conexão rapidamente
    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
