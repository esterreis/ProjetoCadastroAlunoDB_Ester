package br.cnec.fcsl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.cnec.fcsl.entidade.Aluno;


//ester reis
public class AlunoDao {

	Connection conexao = null;
	PreparedStatement preparedSt = null;
	ResultSet result = null;
	
	//construtor sempre inicia conexão com o banco
	public AlunoDao() {
		conexao = new Conexao().conectorBD();//busca o objeto conector da Classe Conexao
	}
	
	
	public void adicionarAluno (Aluno aluno) throws SQLException{
		//string para comando sql no banco
		String sql = "INSERT INTO aluno (nome, nota, faltas) VALUES (?, ?, ?)";
			
		preparedSt = conexao.prepareStatement(sql);
		preparedSt.setString(1, aluno.getNome());
		preparedSt.setDouble(2,  aluno.getNota());
		preparedSt.setInt(3, aluno.getFaltas());
		preparedSt.executeUpdate();
		conexao.close();
	}

	public void atualizarAluno(Aluno aluno) throws SQLException{
		//string para comando sql no banco
		String sql = "UPDATE aluno SET nome = ?, nota = ?, faltas = ? WHERE id = ?";
		
		preparedSt = conexao.prepareStatement(sql);
		preparedSt.setString(1, aluno.getNome());
		preparedSt.setDouble(2, aluno.getNota());
		preparedSt.setInt(3, aluno.getFaltas());
		preparedSt.setLong(4, aluno.getId());
		preparedSt.executeUpdate();
		conexao.close();
	}
		
	public List<Aluno> pesquisarAluno(String nome) throws SQLException{
		//lista de alunos que será devolvida
		List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
		//string para comando sql no banco
		String sql = "SELECT * FROM aluno WHERE nome LIKE ? ";
		
		preparedSt = conexao.prepareStatement(sql);
		preparedSt.setString(1, "%" + nome + "%");//o carcacter 
		result = preparedSt.executeQuery();
		
		while(result.next()){//enquanto houver resultado da pesquisa
			listaDeAlunos.add(new Aluno(result.getLong(1), result.getString(2), result.getDouble(3), result.getInt(4)));
		}
		conexao.close();
		return listaDeAlunos;
	}

	public void excluirAluno(Aluno aluno) throws SQLException{
		
		//string para comando sql no banco
		String sql = "DELETE FROM aluno WHERE id = ?";
		
		preparedSt = conexao.prepareStatement(sql);
		preparedSt.setLong(1, aluno.getId());
		preparedSt.executeUpdate();
		conexao.close();
	}
	
	public List<Aluno> listarAlunos() throws SQLException {
		
		List<Aluno> lista = new ArrayList<Aluno>();
		
		String sql = "SELECT * FROM aluno";
		
		preparedSt = conexao.prepareStatement(sql);
		result = preparedSt.executeQuery();
		while(result.next()){
			lista.add(new Aluno(result.getLong(1), result.getString(2), result.getDouble(3), result.getInt(4)));
		}
		conexao.close();
		return lista;
	}

	
	
}
