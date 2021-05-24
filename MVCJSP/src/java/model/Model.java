package model;

import bean.Aluno;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souza Essa classe controla o acesso ao banco de dados Teremos os
 * seguintes métodos: inserir, pesquisar*, editar, atualizar, excluir pesquisar
 * (listar e listar todos)
 */
public class Model implements Serializable {

    private Connection connection = null;
    private String statusMessage;

    // construtor
    public Model() throws SQLException {
        this.connection = DBConnection.getInstance().getConnection();
    }

    // Esse método vai servir para: pesquisar, editar e excluir
    public List<Aluno> pesquisar(Aluno aluno, String tipo) {
        // Cria a lista para retornar os dados
        List<Aluno> alunos = new ArrayList();

        // Cria a variável para realizar as consultas
        PreparedStatement ps = null;

        // Cria a variável para definirmos as consultas
        String sql = new String();

        try {
            // 1 - montar as expressões SQL
            switch (tipo) {
                case "ra":
                    sql = "SELECT * FROM alunos WHERE ra = ?;";
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, aluno.getRa());
                    break;

                case "nome":
                    sql = "SELECT * FROM alunos WHERE nome = ?;";
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, aluno.getNome());
                    break;

                case "curso":
                    sql = "SELECT * FROM alunos WHERE curso = ? ORDER BY curso, nome ASC;";
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, aluno.getCurso());
                    break;
            }

            // 2 - ResultSet (pegar os resultados do banco de dados)
            ResultSet rs = ps.executeQuery();
            
            // 3 - Montar o while ( colocar os dados recebidos no objeto Aluno)
            while(rs.next()){
                aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setRa(rs.getString("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCurso(rs.getString("curso"));
                
                // 4 - Adicionar na lista
                alunos.add(aluno);
            }
            
            rs.close();
            ps.close();
            
            // 5 - Retornar a lista de alunos
            return alunos;
            
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao pesquisar: " + e.getMessage());
        }
    }

    // Método para listar todos os registros (Menu Listar)
    public List<Aluno> listar() {
        // variável para receber a lista de alunos (registros)
        List<Aluno> alunos = new ArrayList();
        try {
            String sql = "SELECT * FROM alunos ORDER BY nome ASC;";
            try (
                    // preparando a consulta
                    PreparedStatement ps = connection.prepareStatement(sql);
                    // receber o resultado da consulta
                    ResultSet rs = ps.executeQuery()) {

                // percorrer os registros recuperados
                while (rs.next()) { // enquanto houver próximo
                    // cria um objeto para receber os dados da consulta
                    // para cada registro (linha do banco de dados)
                    Aluno aluno = new Aluno();
                    aluno.setId(rs.getInt("id"));
                    aluno.setRa(rs.getString("ra"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCurso(rs.getString("curso"));

                    // coloca os dados dentro da lista (alunos)
                    alunos.add(aluno);
                }
                rs.close(); // fecha a consulta no banco
                ps.close(); // fecha a conexão com o banco de dados
            }
            // retorna a lista de objetos (alunos)
            return alunos;

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao listar.");
        }
    }

    // método para inserir um registro no banco
    public void inserir(Aluno aluno) {
        try {
            String sql = "INSERT INTO alunos (ra, nome, curso) VALUES (?,?,?);";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                // atribuir os valores do objeto "Aluno" ao "ps"
                ps.setString(1, aluno.getRa());
                ps.setString(2, aluno.getNome());
                ps.setString(3, aluno.getCurso());

                // executar a inclusão
                ps.execute();
                ps.close();
            }
            connection.close(); // fecha a conexão com o banco de dados
            this.statusMessage = "Incluído com sucesso";
        } catch (SQLException ex) {
            this.statusMessage = "Falha ao inserir: " + ex.getMessage();
        }
    }

    public void excluir(Aluno aluno) {
        try {
            String sql = "DELETE FROM alunos WHERE ra = ?;";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, aluno.getRa());

                // executar a inclusão
                ps.execute();
                ps.close();
            }
            connection.close(); // fecha a conexão com o banco de dados
            this.statusMessage = "Excluído com sucesso";
        } catch (SQLException ex) {
            this.statusMessage = "Falha ao excluir: " + ex.getMessage();
        }
    }

    @Override // sobrescrita de método
    public String toString() {
        return this.statusMessage;
    }
}
