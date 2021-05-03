package bean;

import java.io.Serializable;

// Essa classe é chamada de POJO (Plain Old Java Objects ou
// Objetos clássicos do Java
public class Aluno implements Serializable {
    private int id;
    private String ra;
    private String nome;
    private String curso;

    public Aluno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
