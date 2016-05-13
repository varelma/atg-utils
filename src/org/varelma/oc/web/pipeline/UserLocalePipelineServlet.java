package org.varelma.oc.web.pipeline;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;

import org.varelma.oc.userprofiling.UserTools;
import org.varelma.oc.util.ComponentResolver;

import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
 

public class UserLocalePipelineServlet extends InsertablePipelineServlet {

 
	public void runServlet(DynamoHttpServletRequest request, DynamoHttpServletResponse response) throws IOException, ServletException {
		Locale locale = UserTools.getCurrentUsersLocale();
		if (locale == null) {
			locale =  (Locale) ComponentResolver.getComponent("/atg/service/localeservice/LocaleService.locale");
			UserTools.setCurrentUsersLocale(locale);
		}
		passRequest(request, response);
	}

 
	
}
