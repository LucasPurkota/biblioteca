package br.edu.up.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LivroNegocio {
	public static Date converterData(String dataNasc) {
		SimpleDateFormat f = new SimpleDateFormat("dd/mm/yyyy");
		try {
			Date dataConvert;
			dataConvert = (Date) f.parse(dataNasc);
			return dataConvert;
		}catch(ParseException e){
			return null;
		}
	}
}
