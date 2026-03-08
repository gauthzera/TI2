package exercicio2.DAO;

import exercicio2.model.Aluno;
import exercicio2.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

	 public void inserir(Aluno aluno) {
	        String sql = "INSERT INTO aluno (nome, idade, curso) VALUES (?, ?, ?)";

	        try (Connection conn = Conexao.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, aluno.getNome());
	            stmt.setInt(2, aluno.getIdade());
	            stmt.setString(3, aluno.getCurso());

	            stmt.executeUpdate();
	            System.out.println("Aluno inserido com sucesso.");

	        } catch (SQLException e) {
	            System.out.println("Erro ao inserir aluno: " + e.getMessage());
	        }
	    }
	
	 public List<Aluno> listar() {
	        List<Aluno> alunos = new ArrayList<>();
	        String sql = "SELECT * FROM aluno ORDER BY id";

	        try (Connection conn = Conexao.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                Aluno aluno = new Aluno();
	                aluno.setId(rs.getInt("id"));
	                aluno.setNome(rs.getString("nome"));
	                aluno.setIdade(rs.getInt("idade"));
	                aluno.setCurso(rs.getString("curso"));

	                alunos.add(aluno);
	            }

	        } catch (SQLException e) {
	            System.out.println("Erro ao listar alunos: " + e.getMessage());
	        }

	        return alunos;
	    }
	
	 public void atualizar(Aluno aluno) {
	        String sql = "UPDATE aluno SET nome = ?, idade = ?, curso = ? WHERE id = ?";

	        try (Connection conn = Conexao.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, aluno.getNome());
	            stmt.setInt(2, aluno.getIdade());
	            stmt.setString(3, aluno.getCurso());
	            stmt.setInt(4, aluno.getId());

	            int linhasAfetadas = stmt.executeUpdate();

	            if (linhasAfetadas > 0) {
	                System.out.println("Aluno atualizado com sucesso.");
	            } else {
	                System.out.println("Aluno não encontrado.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
	        }
	    }
	 
	 public void excluir(int id) {
	        String sql = "DELETE FROM aluno WHERE id = ?";

	        try (Connection conn = Conexao.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, id);

	            int linhasAfetadas = stmt.executeUpdate();

	            if (linhasAfetadas > 0) {
	                System.out.println("Aluno excluído com sucesso.");
	            } else {
	                System.out.println("Aluno não encontrado.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Erro ao excluir aluno: " + e.getMessage());
	        }
	    }
}