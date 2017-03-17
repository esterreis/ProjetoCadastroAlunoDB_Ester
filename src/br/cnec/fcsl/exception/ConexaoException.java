package br.cnec.fcsl.exception;

public class ConexaoException  extends RuntimeException {
		@Override
		public String getMessage() {
			return "Desculpe! Não foi possível conectar à base de dados.";
		}
}

