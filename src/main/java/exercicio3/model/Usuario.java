package exercicio3.model;

public class Usuario {
    private int codigo;
    private String login;
    private char sexo;
    private String senha;

    public Usuario() {
    }

    public Usuario(int codigo, String login, char sexo, String senha) {
        this.codigo = codigo;
        this.login = login;
        this.sexo = sexo;
        this.senha = senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return codigo + " " + login + " " + sexo;
    }
}
