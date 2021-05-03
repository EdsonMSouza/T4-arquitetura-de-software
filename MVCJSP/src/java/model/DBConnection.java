package model;

// importação das classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @file DBConnection.java
 * @brief Classe que realiza conexões do tipo Singleton com o banco de dados
 * @author Edson Melo de Souza
 * @date 20/03/2020
 *
 */
public class DBConnection {

    // configurações para conexão com o bando de dados MySQL
    // é importante que o Driver do MySQL esteja isntalado (bilbiotecas)
    private final String driver = "com.mysql.jdbc.Driver";
    
    
    // enfereço onde está localizado o banco de dados
    private final String url = "jdbc:mysql://localhost:3306/mvcjsp";

    // credenciais de acesso
    private final String usuario = "root";
    private final String senha = "";

    // variável para armazenar a conexão com o banco de dados
    private static DBConnection conexao = null;

    /**
     * Método que prepara a configuração para a conexão
     *
     * @throws SQLException
     */
    private DBConnection() throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new SQLException("driver");
        }
    }

    /**
     * Realiza a conexão, caso tenha sucesso
     *
     * @return Connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return conn;
    }

    /**
     * Retorna uma instância da conexão para utilização (Singleton)
     *
     * @return Connection
     * @throws SQLException
     */
    public static DBConnection getInstance() throws SQLException {
        if (conexao == null) {
            conexao = new DBConnection();
        }
        return conexao;
    }
}
