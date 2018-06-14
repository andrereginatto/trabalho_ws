package br.com.upf.trabalho.ws.dateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormateDate {
	
	public Date pareseData(Date date) {
	
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			String data = fmt.format(date);
			return fmt.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
