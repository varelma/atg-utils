package org.varelma.oc.web.pipeline;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.ServletUtil;
import atg.servlet.pipeline.InsertableServletImpl;

public abstract class InsertablePipelineServlet extends InsertableServletImpl {

	private boolean enabled;
	 
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void service(final DynamoHttpServletRequest request, final DynamoHttpServletResponse response) throws IOException, ServletException {
		if (isEnabled()) {
			runServlet(request, response);
		} else {
			passRequest(request, response);
		}
	}

	public void passRequest(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse) throws IOException, ServletException {
		// this is needed because some atg core classes with get the 
		// the request by doing a ServletUtil.getCurrentRequest()
		// this will make sure that the correctly wrapped request is returned
		ServletUtil.setCurrentRequest(pRequest);
		ServletUtil.setCurrentResponse(pResponse);
		super.passRequest(pRequest, pResponse);
	}

	public abstract void runServlet(DynamoHttpServletRequest request, DynamoHttpServletResponse response) throws IOException, ServletException;

}
