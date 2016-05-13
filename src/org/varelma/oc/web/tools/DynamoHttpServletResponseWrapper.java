package org.varelma.oc.web.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.LocaleToCharsetMapper;

public class DynamoHttpServletResponseWrapper extends DynamoHttpServletResponse {
	private DynamoHttpServletResponse response;

	public void addCookie(Cookie arg0) {
		response.addCookie(arg0);
	}

	public void addCookieToBuffer(Cookie pCookie) {
		response.addCookieToBuffer(pCookie);
	}

	public void addDateHeader(String pName, long pValue) {
		response.addDateHeader(pName, pValue);
	}

	public void addHeader(String pName, String pValue) {
		response.addHeader(pName, pValue);
	}

	public void addIntHeader(String pName, int pValue) {
		response.addIntHeader(pName, pValue);
	}

	public boolean containsHeader(String pName) {
		return response.containsHeader(pName);
	}

	public String encodeRedirectURL(String arg0) {
		return response.encodeRedirectURL(arg0);
	}

	public String encodeRedirectUrl(String url) {
		return response.encodeRedirectUrl(url);
	}

	public String encodeURL(String url) {
		return response.encodeURL(url);
	}

	public String encodeUrl(String url) {
		return response.encodeUrl(url);
	}

	public boolean equals(Object obj) {
		return response.equals(obj);
	}

	public void flushBuffer() throws IOException {
		response.flushBuffer();
	}

	public int getBufferSize() {
		return response.getBufferSize();
	}

	public String getCharacterEncoding() {
		return response.getCharacterEncoding();
	}

	public String getContentType() {
		return response.getContentType();
	}

	public boolean getContentTypeSet() {
		return response.getContentTypeSet();
	}

	public boolean getDoExitTracking() {
		return response.getDoExitTracking();
	}

	public Dictionary getHeaders() {
		return response.getHeaders();
	}

	public Enumeration getHeaders(String pHeaderName) {
		return response.getHeaders(pHeaderName);
	}

	public Locale getLocale() {
		return response.getLocale();
	}

	public LocaleToCharsetMapper getLocaleToCharsetMapper() {
		return response.getLocaleToCharsetMapper();
	}

	public ServletOutputStream getOutputStream() throws IOException {
		return response.getOutputStream();
	}

	public HttpServletResponse getResponse() {
		return response.getResponse();
	}

	public int getStatus() {
		return response.getStatus();
	}

	public ServletResponseWrapper getWrapper() {
		return response.getWrapper();
	}

	public PrintWriter getWriter() throws IOException {
		return response.getWriter();
	}

	public int hashCode() {
		return response.hashCode();
	}

	public boolean isCommitted() {
		return response.isCommitted();
	}

	public boolean isOutputStreamRetrieved() {
		return response.isOutputStreamRetrieved();
	}

	public boolean isOutputStreamUsed() {
		return response.isOutputStreamUsed();
	}

	public boolean isResponseComplete() {
		return response.isResponseComplete();
	}

	public boolean isWriterUsed() {
		return response.isWriterUsed();
	}

	public void reset() {
		response.reset();
	}

	public void resetBuffer() {
		response.resetBuffer();
	}

	public void sendError(int arg0, String arg1) throws IOException {
		response.sendError(arg0, arg1);
	}

	public void sendError(int arg0) throws IOException {
		response.sendError(arg0);
	}

	public void sendLocalRedirect(String arg0, DynamoHttpServletRequest arg1) throws IOException {
		response.sendLocalRedirect(arg0, arg1);
	}

	public void sendRedirect(String arg0) throws IOException {
		response.sendRedirect(arg0);
	}

	public void setBufferSize(int pBufferSize) {
		response.setBufferSize(pBufferSize);
	}

	public void setCharacterEncoding(String charset) {
		response.setCharacterEncoding(charset);
	}

	public void setContentLength(int pLength) {
		response.setContentLength(pLength);
	}

	public void setContentType(String arg0) {
		response.setContentType(arg0);
	}

	public void setContentTypeSet(boolean pContentTypeSet) {
		response.setContentTypeSet(pContentTypeSet);
	}

	public void setDateHeader(String pName, long pValue) {
		response.setDateHeader(pName, pValue);
	}

	public void setDoExitTracking(boolean pDoExitTracking) {
		response.setDoExitTracking(pDoExitTracking);
	}

	public void setHeader(String pName, String pValue) {
		response.setHeader(pName, pValue);
	}

	public void setIntHeader(String pName, int pValue) {
		response.setIntHeader(pName, pValue);
	}

	public void setLocale(Locale arg0) {
		response.setLocale(arg0);
	}

	public void setLocaleToCharsetMapper(LocaleToCharsetMapper pMapper) {
		response.setLocaleToCharsetMapper(pMapper);
	}

	public void setOutputStream(ServletOutputStream pOutputStream) {
		response.setOutputStream(pOutputStream);
	}

	public void setRequest(DynamoHttpServletRequest pRequest) {
		response.setRequest(pRequest);
	}

	public void setResponse(HttpServletResponse pResponse) {
		response.setResponse(pResponse);
	}

	public void setStatus(int pCode, String pMessage) {
		response.setStatus(pCode, pMessage);
	}

	public void setStatus(int pCode) {
		response.setStatus(pCode);
	}

	public boolean setStrictOutputAccess(boolean pStrict) {
		return response.setStrictOutputAccess(pStrict);
	}

	public void setWrapper(ServletResponseWrapper pWrapper) {
		response.setWrapper(pWrapper);
	}

	public void setWriter(PrintWriter pWriter) {
		response.setWriter(pWriter);
	}

	public String toString() {
		return response.toString();
	}

	public DynamoHttpServletResponseWrapper(DynamoHttpServletResponse response) {
		this.response = response;
	}
}
