package br.cnec.fcsl.exception;

public class ConexaoException  extends RuntimeException {
		@Override
		public String getMessage() {
			return "Desculpe! N�o foi poss�vel conectar � base de dados.";
		}
}

