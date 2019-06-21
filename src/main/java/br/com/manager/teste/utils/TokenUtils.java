package br.com.manager.teste.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public abstract class TokenUtils {

	public static Timestamp generateTokenDateExpiration() {
		return new Timestamp(new Date(Calendar.getInstance().getTimeInMillis() + (5 * 60000)).getTime());
	}

}
