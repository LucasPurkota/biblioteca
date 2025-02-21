package br.edu.up.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteData {
	public static Date converterData(String data) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataConvert;
			dataConvert = (Date) f.parse(data);
			return dataConvert;
		}catch(ParseException e){
			return null;
		}
	}

	public static String converteDataString(Date data) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String dataConvert;
			dataConvert = (String) f.format(data);
			return dataConvert;
		}catch(Exception e){
			return null;
		}
	}
}
