package org.varelma.oc.i18n;

import java.util.Locale;

import org.varelma.oc.util.ComponentResolver;

import atg.nucleus.logging.ApplicationLogging;
import atg.nucleus.logging.ClassLoggingFactory;
import atg.repository.Repository;
import atg.repository.RepositoryException;
import atg.repository.RepositoryItem;

public class TranslationTools {

	private static final Repository I18N_REPOSITORY;

	// to configure go to http://localhost:8080/dyn/admin/nucleus/atg/dynamo/service/logging/ClassLoggingFactory/
	private static ApplicationLogging mLogger = ClassLoggingFactory.getFactory().getLoggerForClass(TranslationTools.class);

	static {
		I18N_REPOSITORY = (Repository) ComponentResolver.getComponent("/org/varelma/oc/i18n/I18nRepository");
	}

	public static String translate(String key, Locale locale) {
		RepositoryItem tranlationItem = null;
		String result = "";
		try {
			tranlationItem = I18N_REPOSITORY.getItem(key + "_" + locale.toString(), "translation");
		} catch (RepositoryException e) {
			mLogger.logError(e);
		}
		if (tranlationItem != null) {
			result = (String) tranlationItem.getPropertyValue("value");
		}
		return result;
	}
}
