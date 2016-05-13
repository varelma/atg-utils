package org.varelma.oc.userprofiling;

import java.util.Locale;


/**
 *
 * A simple threadLocal Locale used to store the current users locale
 *
 * @author jon pallas
 *
 */
public class UserTools {

	private static final ThreadLocal<Locale> usersLocaleThreadLocal = new ThreadLocal<Locale>();

	public static Locale getCurrentUsersLocale() {
		Locale locale = usersLocaleThreadLocal.get();
		return locale;
	}

	public static void setCurrentUsersLocale(Locale locale) {
		usersLocaleThreadLocal.set(locale);
	}

    public static void setCurrentUsersLocaleString(String localeStr) {
        Locale locale;
        if (localeStr != null) {
            String[] parts = localeStr.split("_", 3);
            switch (parts.length) {
                case 1:
                    locale = new Locale(parts[0]);
                    break;
                case 2:
                    locale = new Locale(parts[0], parts[1]);
                    break;
                default:
                    locale = new Locale(parts[0], parts[1], parts[2]);
            }
        } else {
            locale = Locale.getDefault();
        }
        setCurrentUsersLocale(locale);
    }
}
