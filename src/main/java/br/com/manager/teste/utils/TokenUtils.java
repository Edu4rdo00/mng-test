package br.com.manager.teste.utils;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public abstract class TokenUtils {

	private static SecureRandom random = new SecureRandom();

	public static synchronized String generateToken() {
		long longToken = Math.abs(random.nextLong());
		return Long.toString(longToken, 32);
	}

	public static Timestamp generateTokenDateExpiration() {
		return new Timestamp(new Date(Calendar.getInstance().getTimeInMillis() + (5 * 60000)).getTime());
	}

}
