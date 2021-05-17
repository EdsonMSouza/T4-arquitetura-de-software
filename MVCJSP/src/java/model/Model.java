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
    public List<Aluno> pesquisar(Aluno aluno,  String tipo){
        List<Aluno> alunos = new ArrayList();
        
        // 1 - montar as exopressões SQL
        // 2 - ResultSet
        // 3 - Montar o while
        // 4 - Adicionar na lista
        // 5 - Retornar a lista de alunos
        return alunos;
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
