package br.cnec.fcsl.dao;

import java.sql.Connection;
import java.sql.SQLException;
//ester reis
public class AlunoDao {

	private Connection conexao;
	
	public AlunoDao() throws ClassNotFoundException, SQLException{
		conexao = new Conexao().conectarComBanco();
	}
	
	 
	
}
