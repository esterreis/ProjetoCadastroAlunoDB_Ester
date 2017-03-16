package br.cnec.fcsl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.cnec.fcsl.persistencia.ParametrosMySql;
//ester reis
public class Conexao {

	public Connection conectarComBanco () throws ClassNotFoundException, SQLException{
		
		Class.forName(ParametrosMySql.DRIVER);
		
		Connection conexao = DriverManager.getConnection(ParametrosMySql.URL, ParametrosMySql.USUARIO, ParametrosMySql.SENHA );
		return conexao;
	}
}
