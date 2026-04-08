package exercicio3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import exercicio3.model.Usuario;

public class UsuarioDAO {
    private Connection db;

    public UsuarioDAO() {
        conectar();
    }

    private void conectar() {
        try {
            String url = "jdbc:postgresql://localhost:5432/teste";
            String username = "postgres";
            String password = "ti2cc";

            Properties prop = new Properties();
            prop.setProperty("user", username);
            prop.setProperty("password", password);

            db = DriverManager.getConnection(url, prop);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no PostgreSQL: " + e.getMessage(), e);
        }
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT codigo, login, senha, sexo FROM usuario ORDER BY codigo";

        try (Statement st = db.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                char sexo = rs.getString("sexo").charAt(0);

                lista.add(new Usuario(codigo, login, sexo, senha));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro na consulta: " + e.getMessage(), e);
        }

        return lista;
    }

    public Usuario getUsuarioPorCodigo(int codigo) {
        String sql = "SELECT codigo, login, senha, sexo FROM usuario WHERE codigo = ?";

        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("codigo"),
                        rs.getString("login"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage(), e);
        }

        return null;
    }

    public void inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (codigo, login, senha, sexo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setInt(1, usuario.getCodigo());
            pstmt.setString(2, usuario.getLogin());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setString(4, String.valueOf(usuario.getSexo()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro na inserção: " + e.getMessage(), e);
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET login = ?, senha = ?, sexo = ? WHERE codigo = ?";

        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, String.valueOf(usuario.getSexo()));
            pstmt.setInt(4, usuario.getCodigo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro na atualização: " + e.getMessage(), e);
        }
    }

    public void excluirUsuario(int codigo) {
        String sql = "DELETE FROM usuario WHERE codigo = ?";

        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro na deleção: " + e.getMessage(), e);
        }
    }
}
