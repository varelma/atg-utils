package org.varelma.oc.web.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import atg.droplet.TagConverter;
import atg.naming.NameContext;
import atg.nucleus.Nucleus;
import atg.nucleus.RequestScopeManager;
import atg.nucleus.WindowScopeManager;
import atg.nucleus.logging.ApplicationLogging;
import atg.nucleus.naming.ComponentName;
import atg.nucleus.naming.ParameterName;
import atg.security.UserAuthenticator;
import atg.servlet.AttributeFactory;
import atg.servlet.BrowserTyper;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.HttpSessionRequest;
import atg.servlet.MimeTyper;
import atg.servlet.ParameterHandler;
import atg.servlet.RequestLocale;
import atg.servlet.exittracking.ExitTrackingHandler;
import atg.servlet.minimal.WebApplicationInterface;

public class DynamoHttpServletRequestWrapper extends DynamoHttpServletRequest {
	private DynamoHttpServletRequest request;

	public void addPersistentQueryParameter(String arg0, String arg1) {
		request.addPersistentQueryParameter(arg0, arg1);
	}

	public void addQueryParameter(String arg0, String arg1) {
		request.addQueryParameter(arg0, arg1);
	}

	public void addURLParameter(String pKey, String pValue) {
		request.addURLParameter(pKey, pValue);
	}

	public String encodeURL(String arg0, boolean arg1, boolean arg2, boolean arg3, boolean arg4, boolean arg5, int arg6) {
		return request.encodeURL(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	public String encodeURL(String pURL, boolean pEncodeParameters, boolean pClearParameters, boolean pIsImageURL, boolean pInterpretURIs, boolean pDoExitTracking) {
		return request.encodeURL(pURL, pEncodeParameters, pClearParameters, pIsImageURL, pInterpretURIs, pDoExitTracking);
	}

	public String encodeURL(String pURL, boolean pEncodeParameters, boolean pClearParameters, boolean pIsImageURL, boolean pInterpretURIs) {
		return request.encodeURL(pURL, pEncodeParameters, pClearParameters, pIsImageURL, pInterpretURIs);
	}

	public String encodeURL(String pURL, boolean pEncodeParameters, boolean pClearParameters, boolean pIsImageURL) {
		return request.encodeURL(pURL, pEncodeParameters, pClearParameters, pIsImageURL);
	}

	public String encodeURL(String pURL, boolean pClearParameters) {
		return request.encodeURL(pURL, pClearParameters);
	}

	public String encodeURL(String pURL) {
		return request.encodeURL(pURL);
	}

	public void endRequest() {
		request.endRequest();
	}

	public boolean equals(Object arg0) {
		return request.equals(arg0);
	}

	public Object getAttribute(String arg0, boolean arg1) {
		return request.getAttribute(arg0, arg1);
	}

	public Object getAttribute(String p0) {
		return request.getAttribute(p0);
	}

	public Enumeration getAttributeNames() {
		return request.getAttributeNames();
	}

	public String getAuthType() {
		return request.getAuthType();
	}

	public String getBaseDirectory() {
		return request.getBaseDirectory();
	}

	public BrowserTyper getBrowserTyper() {
		return request.getBrowserTyper();
	}

	public String getCharacterEncoding() {
		return request.getCharacterEncoding();
	}

	public int getContentLength() {
		return request.getContentLength();
	}

	public String getContentType() {
		return request.getContentType();
	}

	public String getContextPath() {
		return request.getContextPath();
	}

	public String getCookieParameter(String pKey, int pIndex) {
		return request.getCookieParameter(pKey, pIndex);
	}

	public String getCookieParameter(String pKey) {
		return request.getCookieParameter(pKey);
	}

	public int getCookieParameterCount(String pKey) {
		return request.getCookieParameterCount(pKey);
	}

	public Enumeration getCookieParameterNames() {
		return request.getCookieParameterNames();
	}

	public String[] getCookieParameterValues(String pKey) {
		return request.getCookieParameterValues(pKey);
	}

	public Cookie[] getCookies() {
		return request.getCookies();
	}

	public long getDateHeader(String p0) {
		return request.getDateHeader(p0);
	}

	public boolean getDisableExitTracking() {
		return request.getDisableExitTracking();
	}

	public String getDocRootServicePrefix() {
		return request.getDocRootServicePrefix();
	}

	public int getEncodeContextPathMode() {
		return request.getEncodeContextPathMode();
	}

	public boolean getEncodeServletPath() {
		return request.getEncodeServletPath();
	}

	public boolean getEncodeURL() {
		return request.getEncodeURL();
	}

	public int getEventFlags() {
		return request.getEventFlags();
	}

	public ExitTrackingHandler getExitTrackingHandler() {
		return request.getExitTrackingHandler();
	}

	public String getExitTrackingParameterName() {
		return request.getExitTrackingParameterName();
	}

	public boolean getFormEventsSent() {
		return request.getFormEventsSent();
	}

	public boolean getGenerateRequestLocales() {
		return request.getGenerateRequestLocales();
	}

	public String getHeader(String p0) {
		return request.getHeader(p0);
	}

	public Enumeration getHeaderNames() {
		return request.getHeaderNames();
	}

	public Enumeration getHeaders(String pName) {
		return request.getHeaders(pName);
	}

	public ServletInputStream getInputStream() throws IOException {
		return request.getInputStream();
	}

	public int getIntHeader(String p0) {
		return request.getIntHeader(p0);
	}

	public String getLinkEncoding() {
		return request.getLinkEncoding();
	}

	public String getLocalAddr() {
		return request.getLocalAddr();
	}

	public String getLocalName() {
		return request.getLocalName();
	}

	public Object getLocalParameter(ParameterName pName) {
		return request.getLocalParameter(pName);
	}

	public Object getLocalParameter(String pName) {
		return request.getLocalParameter(pName);
	}

	public int getLocalPort() {
		return request.getLocalPort();
	}

	public Locale getLocale() {
		return request.getLocale();
	}

	public Enumeration getLocales() {
		return request.getLocales();
	}

	public Map getMapForCurrentFrame() {
		return request.getMapForCurrentFrame();
	}

	public String getMethod() {
		return request.getMethod();
	}

	public String getMimeType() {
		return request.getMimeType();
	}

	public MimeTyper getMimeTyper() {
		return request.getMimeTyper();
	}

	public Nucleus getNucleus() {
		return request.getNucleus();
	}

	public Object getObjectParameter(ParameterName pName) {
		return request.getObjectParameter(pName);
	}

	public Object getObjectParameter(String pName) {
		return request.getObjectParameter(pName);
	}

	public Object getObjectURLParameter(String pKey, int pIndex) {
		return request.getObjectURLParameter(pKey, pIndex);
	}

	public Map getParamMapForTopFrame() {
		return request.getParamMapForTopFrame();
	}

	public String getParameter(ParameterName arg0) {
		return request.getParameter(arg0);
	}

	public String getParameter(String pName) {
		return request.getParameter(pName);
	}

	public String getParameterDelimiter() {
		return request.getParameterDelimiter();
	}

	public Map getParameterMap() {
		return request.getParameterMap();
	}

	public Enumeration getParameterNames() {
		return request.getParameterNames();
	}

	public Enumeration getParameterNamesInStack() {
		return request.getParameterNamesInStack();
	}

	public String[] getParameterValues(String pName) {
		return request.getParameterValues(pName);
	}

	public String getPathInfo() {
		return request.getPathInfo();
	}

	public String getPathTranslated() {
		return request.getPathTranslated();
	}

	public Object getPermanentAttribute(AttributeFactory arg0) {
		return request.getPermanentAttribute(arg0);
	}

	public String getPostParameter(String arg0, int arg1) {
		return request.getPostParameter(arg0, arg1);
	}

	public String getPostParameter(String arg0) {
		return request.getPostParameter(arg0);
	}

	public int getPostParameterCount(String arg0) {
		return request.getPostParameterCount(arg0);
	}

	public Enumeration getPostParameterNames() {
		return request.getPostParameterNames();
	}

	public String[] getPostParameterValues(String pKey) {
		return request.getPostParameterValues(pKey);
	}

	public String getProtocol() {
		return request.getProtocol();
	}

	public String getQueryParameter(String arg0, int arg1) {
		return request.getQueryParameter(arg0, arg1);
	}

	public String getQueryParameter(String pKey) {
		return request.getQueryParameter(pKey);
	}

	public int getQueryParameterCount(String pKey) {
		return request.getQueryParameterCount(pKey);
	}

	public Enumeration getQueryParameterNames() {
		return request.getQueryParameterNames();
	}

	public String[] getQueryParameterValues(String pKey) {
		return request.getQueryParameterValues(pKey);
	}

	public String getQueryString() {
		return request.getQueryString();
	}

	public BufferedReader getReader() throws IOException {
		return request.getReader();
	}

	public String getRealPath(String pPath) {
		return request.getRealPath(pPath);
	}

	public String getRemoteAddr() {
		return request.getRemoteAddr();
	}

	public String getRemoteHost() {
		return request.getRemoteHost();
	}

	public int getRemotePort() {
		return request.getRemotePort();
	}

	public String getRemoteUser() {
		return request.getRemoteUser();
	}

	public HttpServletRequest getRequest() {
		return request.getRequest();
	}

	public RequestDispatcher getRequestDispatcher(ServletContext pContext, String pPath) {
		return request.getRequestDispatcher(pContext, pPath);
	}

	public RequestDispatcher getRequestDispatcher(String pPath) {
		return request.getRequestDispatcher(pPath);
	}

	public DynamoHttpServletRequest getRequestForComparison() {
		return request.getRequestForComparison();
	}

	public RequestLocale getRequestLocale() {
		return request.getRequestLocale();
	}

	public ComponentName getRequestLocalePath() {
		return request.getRequestLocalePath();
	}

	public NameContext getRequestScope() {
		return request.getRequestScope();
	}

	public RequestScopeManager getRequestScopeManager() {
		return request.getRequestScopeManager();
	}

	public String getRequestURI() {
		return request.getRequestURI();
	}

	public String getRequestURIWithQueryString() {
		return request.getRequestURIWithQueryString();
	}

	public StringBuffer getRequestURL() {
		return request.getRequestURL();
	}

	public String getRequestedSessionId() {
		return request.getRequestedSessionId();
	}

	public DynamoHttpServletResponse getResponse() {
		return request.getResponse();
	}

	public String getRestorableSessionIdFromURL() {
		return request.getRestorableSessionIdFromURL();
	}

	public String getScheme() {
		return request.getScheme();
	}

	public byte[] getScrambleKey() {
		return request.getScrambleKey();
	}

	public String getServerName() {
		return request.getServerName();
	}

	public int getServerPort() {
		return request.getServerPort();
	}

	public String getServletPath() {
		return request.getServletPath();
	}

	public HttpSession getSession() {
		return request.getSession();
	}

	public HttpSession getSession(boolean create) {
		return request.getSession(create);
	}

	public long getSessionConfirmationNumber() {
		return request.getSessionConfirmationNumber();
	}

	public NameContext getSessionNameContext() {
		return request.getSessionNameContext();
	}

	public HttpSessionRequest getSessionRequest() {
		return request.getSessionRequest();
	}

	public HttpSessionRequest getSessionRequest(boolean arg0) {
		return request.getSessionRequest(arg0);
	}

	public String getURLParameter(String pKey, int pIndex) {
		return request.getURLParameter(pKey, pIndex);
	}

	public String getURLParameter(String pKey) {
		return request.getURLParameter(pKey);
	}

	public int getURLParameterCount(String pKey) {
		return request.getURLParameterCount(pKey);
	}

	public Enumeration getURLParameterNames() {
		return request.getURLParameterNames();
	}

	public String getURLParameterString() {
		return request.getURLParameterString();
	}

	public String[] getURLParameterValues(String pKey) {
		return request.getURLParameterValues(pKey);
	}

	public String getURLSessionIdSpecifier() {
		return request.getURLSessionIdSpecifier();
	}

	public UserAuthenticator getUserAuthenticator() {
		return request.getUserAuthenticator();
	}

	public Principal getUserPrincipal() {
		return request.getUserPrincipal();
	}

	public WebApplicationInterface getWebApplication() {
		return request.getWebApplication();
	}

	public NameContext getWindowScope() {
		return request.getWindowScope();
	}

	public WindowScopeManager getWindowScopeManager() {
		return request.getWindowScopeManager();
	}

	public String getWorkingDirectory() {
		return request.getWorkingDirectory();
	}

	public ServletRequestWrapper getWrapper() {
		return request.getWrapper();
	}

	public boolean hasRequestScope() {
		return request.hasRequestScope();
	}

	public int hashCode() {
		return request.hashCode();
	}

	public boolean isAfterGetsClaimed() {
		return request.isAfterGetsClaimed();
	}

	public boolean isBrowserType(String pFeature) {
		return request.isBrowserType(pFeature);
	}

	public boolean isDelayedRequest() {
		return request.isDelayedRequest();
	}

	public boolean isDynamoPipeline() {
		return request.isDynamoPipeline();
	}

	public boolean isInTemplatePage() {
		return request.isInTemplatePage();
	}

	public boolean isInitialized() {
		return request.isInitialized();
	}

	public boolean isLoggingDebug() {
		return request.isLoggingDebug();
	}

	public boolean isLoggingError() {
		return request.isLoggingError();
	}

	public boolean isLoggingInfo() {
		return request.isLoggingInfo();
	}

	public boolean isLoggingWarning() {
		return request.isLoggingWarning();
	}

	public boolean isRequestedSessionIdFromCookie() {
		return request.isRequestedSessionIdFromCookie();
	}

	public boolean isRequestedSessionIdFromURL() {
		return request.isRequestedSessionIdFromURL();
	}

	public boolean isRequestedSessionIdFromUrl() {
		return request.isRequestedSessionIdFromUrl();
	}

	public boolean isRequestedSessionIdValid() {
		return request.isRequestedSessionIdValid();
	}

	public boolean isSecure() {
		return request.isSecure();
	}

	public boolean isUserInRole(String pRole) {
		return request.isUserInRole(pRole);
	}

	public void logDebug(String pMessage, Throwable pThrowable) {
		request.logDebug(pMessage, pThrowable);
	}

	public void logDebug(String pMessage) {
		request.logDebug(pMessage);
	}

	public void logDebug(Throwable pThrowable) {
		request.logDebug(pThrowable);
	}

	public void logError(String pMessage, Throwable pThrowable) {
		request.logError(pMessage, pThrowable);
	}

	public void logError(String pMessage) {
		request.logError(pMessage);
	}

	public void logError(Throwable pThrowable) {
		request.logError(pThrowable);
	}

	public void logInfo(String pMessage, Throwable pThrowable) {
		request.logInfo(pMessage, pThrowable);
	}

	public void logInfo(String pMessage) {
		request.logInfo(pMessage);
	}

	public void logInfo(Throwable pThrowable) {
		request.logInfo(pThrowable);
	}

	public void logWarning(String pMessage, Throwable pThrowable) {
		request.logWarning(pMessage, pThrowable);
	}

	public void logWarning(String pMessage) {
		request.logWarning(pMessage);
	}

	public void logWarning(Throwable pThrowable) {
		request.logWarning(pThrowable);
	}

	public String performExitTracking(String pURL) {
		return request.performExitTracking(pURL);
	}

	public void popDefaultParameters() {
		request.popDefaultParameters();
	}

	public void popFrame() {
		request.popFrame();
	}

	public void popParameters() {
		request.popParameters();
	}

	public void printRequest(PrintStream arg0) {
		request.printRequest(arg0);
	}

	public void pushDefaultParameters(Dictionary pDict) {
		request.pushDefaultParameters(pDict);
	}

	public void pushFrame() {
		request.pushFrame();
	}

	public void pushParameters(Dictionary pDict) {
		request.pushParameters(pDict);
	}

	public void removeAttribute(String pName) {
		request.removeAttribute(pName);
	}

	public Object removeParameter(String pName) {
		return request.removeParameter(pName);
	}

	public void removePersistentQueryParameter(String arg0) {
		request.removePersistentQueryParameter(arg0);
	}

	public void removeSessionFromRequest() {
		request.removeSessionFromRequest();
	}

	public Object resolveGlobalName(ComponentName pName) {
		return request.resolveGlobalName(pName);
	}

	public Object resolveGlobalName(String pName) {
		return request.resolveGlobalName(pName);
	}

	public Object resolveName(ComponentName pName, boolean pCreate) {
		return request.resolveName(pName, pCreate);
	}

	public Object resolveName(ComponentName pName) {
		return request.resolveName(pName);
	}

	public Object resolveName(String pName, boolean pCreate) {
		return request.resolveName(pName, pCreate);
	}

	public Object resolveName(String pName) {
		return request.resolveName(pName);
	}

	public Object resolveRequestName(ComponentName pName) {
		return request.resolveRequestName(pName);
	}

	public Object resolveRequestName(String pName) {
		return request.resolveRequestName(pName);
	}

	public Object resolveSessionName(ComponentName pName) {
		return request.resolveSessionName(pName);
	}

	public Object resolveSessionName(String pName) {
		return request.resolveSessionName(pName);
	}

	public boolean serviceLocalParameter(ParameterName arg0, ServletRequest arg1, ServletResponse arg2) throws ServletException, IOException {
		return request.serviceLocalParameter(arg0, arg1, arg2);
	}

	public boolean serviceLocalParameter(String pName, ServletRequest pReq, ServletResponse pRes) throws ServletException, IOException {
		return request.serviceLocalParameter(pName, pReq, pRes);
	}

	public boolean serviceParameter(ParameterName arg0, ServletRequest arg1, ServletResponse arg2, TagConverter arg3, Properties arg4) throws ServletException, IOException {
		return request.serviceParameter(arg0, arg1, arg2, arg3, arg4);
	}

	public boolean serviceParameter(ParameterName pName, ServletRequest pReq, ServletResponse pRes) throws ServletException, IOException {
		return request.serviceParameter(pName, pReq, pRes);
	}

	public boolean serviceParameter(String pName, ServletRequest pReq, ServletResponse pRes, TagConverter pCvt, Properties pCvtArgs) throws ServletException, IOException {
		return request.serviceParameter(pName, pReq, pRes, pCvt, pCvtArgs);
	}

	public boolean serviceParameter(String pName, ServletRequest pReq, ServletResponse pRes) throws ServletException, IOException {
		return request.serviceParameter(pName, pReq, pRes);
	}

	public void setAfterGetsClaimed(boolean pAfterGetsClaimed) {
		request.setAfterGetsClaimed(pAfterGetsClaimed);
	}

	public void setAttribute(String pName, Object pValue) {
		request.setAttribute(pName, pValue);
	}

	public void setAttributeFactory(String pName, AttributeFactory pFactory) {
		request.setAttributeFactory(pName, pFactory);
	}

	public void setAuthType(String pAuthType) {
		request.setAuthType(pAuthType);
	}

	public void setBaseDirectory(String pBaseDir) {
		request.setBaseDirectory(pBaseDir);
	}

	public void setBrowserTyper(BrowserTyper pBrowserTyper) {
		request.setBrowserTyper(pBrowserTyper);
	}

	public void setCharacterEncoding(String pEncoding) throws UnsupportedEncodingException {
		request.setCharacterEncoding(pEncoding);
	}

	public void setContentLength(int pContentLength) {
		request.setContentLength(pContentLength);
	}

	public void setContentType(String pContentType) {
		request.setContentType(pContentType);
	}

	public void setContextPath(String pContextPath) {
		request.setContextPath(pContextPath);
	}

	public void setDisableExitTracking(boolean pDisableExitTracking) {
		request.setDisableExitTracking(pDisableExitTracking);
	}

	public void setDocRootServicePrefix(String pDocRootServicePrefix) {
		request.setDocRootServicePrefix(pDocRootServicePrefix);
	}

	public void setDynamoPipeline(boolean pDynamoPipeline) {
		request.setDynamoPipeline(pDynamoPipeline);
	}

	public void setEncodeContextPathMode(int pEncodeMode) {
		request.setEncodeContextPathMode(pEncodeMode);
	}

	public void setEncodeServletPath(boolean pEncode) {
		request.setEncodeServletPath(pEncode);
	}

	public void setEncodeURL(boolean pEncodeURL) {
		request.setEncodeURL(pEncodeURL);
	}

	public void setEventFlags(int pEventFlags) {
		request.setEventFlags(pEventFlags);
	}

	public void setExitTrackingHandler(ExitTrackingHandler pExitTrackingHandler) {
		request.setExitTrackingHandler(pExitTrackingHandler);
	}

	public void setFormEventsSent(boolean pFormEventsSent) {
		request.setFormEventsSent(pFormEventsSent);
	}

	public void setGenerateRequestLocales(boolean pValue) {
		request.setGenerateRequestLocales(pValue);
	}

	public void setInTemplatePage(boolean pInTemplatePage) {
		request.setInTemplatePage(pInTemplatePage);
	}

	public void setInitialized(boolean pInitialized) {
		request.setInitialized(pInitialized);
	}

	public void setInputStream(ServletInputStream pInputStream) {
		request.setInputStream(pInputStream);
	}

	public void setLinkEncoding(String pLinkEncoding) {
		request.setLinkEncoding(pLinkEncoding);
	}

	public void setLog(ApplicationLogging pLog) {
		request.setLog(pLog);
	}

	public void setLoggingDebug(boolean pLogging) {
		request.setLoggingDebug(pLogging);
	}

	public void setLoggingError(boolean pLogging) {
		request.setLoggingError(pLogging);
	}

	public void setLoggingInfo(boolean pLogging) {
		request.setLoggingInfo(pLogging);
	}

	public void setLoggingWarning(boolean pLogging) {
		request.setLoggingWarning(pLogging);
	}

	public void setMethod(String pMethod) {
		request.setMethod(pMethod);
	}

	public void setMimeType(String pMimeType) {
		request.setMimeType(pMimeType);
	}

	public void setMimeTyper(MimeTyper pMimeTyper) {
		request.setMimeTyper(pMimeTyper);
	}

	public void setNucleus(Nucleus pNucleus) {
		request.setNucleus(pNucleus);
	}

	public void setParameter(String pName, Object pValue, TagConverter pCvt, Properties pCvtArgs) throws ServletException {
		request.setParameter(pName, pValue, pCvt, pCvtArgs);
	}

	public void setParameter(String pName, Object pValue) {
		request.setParameter(pName, pValue);
	}

	public void setParameterDelimiter(String pParameterDelimiter) {
		request.setParameterDelimiter(pParameterDelimiter);
	}

	public void setParameterHandler(ParameterHandler pParameterHandler) {
		request.setParameterHandler(pParameterHandler);
	}

	public void setPathInfo(String pPathInfo) {
		request.setPathInfo(pPathInfo);
	}

	public void setPathTranslated(String pPathTranslated) {
		request.setPathTranslated(pPathTranslated);
	}

	public void setProtocol(String pProtocol) {
		request.setProtocol(pProtocol);
	}

	public void setQueryString(String pQueryString) {
		request.setQueryString(pQueryString);
	}

	public void setRemoteAddr(String pRemoteAddr) {
		request.setRemoteAddr(pRemoteAddr);
	}

	public void setRemoteHost(String pRemoteHost) {
		request.setRemoteHost(pRemoteHost);
	}

	public void setRemoteUser(String pRemoteUser) {
		request.setRemoteUser(pRemoteUser);
	}

	public void setRequest(HttpServletRequest pRequest) {
		request.setRequest(pRequest);
	}

	public void setRequestLocale(RequestLocale pLocale) {
		request.setRequestLocale(pLocale);
	}

	public void setRequestLocalePath(ComponentName pValue) {
		request.setRequestLocalePath(pValue);
	}

	public void setRequestScope(NameContext pRequestScope) {
		request.setRequestScope(pRequestScope);
	}

	public void setRequestScopeManager(RequestScopeManager pRequestScopeManager) {
		request.setRequestScopeManager(pRequestScopeManager);
	}

	public void setRequestURI(String pRequestURI) {
		request.setRequestURI(pRequestURI);
	}

	public void setRequestURIHasQueryString(boolean pRequestURIHasQueryString) {
		request.setRequestURIHasQueryString(pRequestURIHasQueryString);
	}

	public void setResponse(DynamoHttpServletResponse pResponse) {
		request.setResponse(pResponse);
	}

	public void setRestorableSessionIdFromURL(String pRestorableSessionIdFromURL) {
		request.setRestorableSessionIdFromURL(pRestorableSessionIdFromURL);
	}

	public void setScheme(String pScheme) {
		request.setScheme(pScheme);
	}

	public void setScrambleKey(byte[] pScrambleKey) {
		request.setScrambleKey(pScrambleKey);
	}

	public void setServerName(String pServerName) {
		request.setServerName(pServerName);
	}

	public void setServerPort(int pServerPort) {
		request.setServerPort(pServerPort);
	}

	public void setServletPath(String pServletPath) {
		request.setServletPath(pServletPath);
	}

	public void setSessionRequest(HttpSessionRequest pSessionRequest) {
		request.setSessionRequest(pSessionRequest);
	}

	public void setURLSessionIdSpecifier(String pURLSessionIdSpecifier) {
		request.setURLSessionIdSpecifier(pURLSessionIdSpecifier);
	}

	public void setUserAuthenticator(UserAuthenticator pUserAuthenticator) {
		request.setUserAuthenticator(pUserAuthenticator);
	}

	public void setWebApplication(WebApplicationInterface pWebApplication) {
		request.setWebApplication(pWebApplication);
	}

	public void setWindowScopeManager(WindowScopeManager pScopeManager) {
		request.setWindowScopeManager(pScopeManager);
	}

	public void setWrapper(ServletRequestWrapper pWrapper) {
		request.setWrapper(pWrapper);
	}

	public void setupLoopbackTemplateEmailRequest() {
		request.setupLoopbackTemplateEmailRequest();
	}

	public boolean shouldExitTrack(String pURL) {
		return request.shouldExitTrack(pURL);
	}

	public boolean tamperedURLParameters() {
		return request.tamperedURLParameters();
	}

	public String toString() {
		return request.toString();
	}

	public DynamoHttpServletRequestWrapper(DynamoHttpServletRequest request) {
		this.request = request;
	}

}
