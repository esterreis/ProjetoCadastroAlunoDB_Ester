package br.cnec.fcsl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.cnec.fcsl.exception.ConexaoException;
import br.cnec.fcsl.persistencia.ParametrosMySql;

//ester reis
public class Conexao {
	public static Connection conectorBD(){
        java.sql.Connection conexao = null;
        try{
        	//passagem de parametros para identificar o bd
        	Class.forName(ParametrosMySql.DRIVER);
        	conexao = DriverManager.getConnection(ParametrosMySql.URL, ParametrosMySql.USUARIO, ParametrosMySql.SENHA );
        	return conexao;
        }catch (Exception ConectionException){
        	JOptionPane.showMessageDialog(null, ConectionException.getMessage());
        	return null;
        }
		
}
}
