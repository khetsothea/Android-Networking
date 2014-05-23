/*
 * 
 * Copyright (C) 2014 CodeMagnus. All Rights Reserved.
 * Created by Edgar Harold C. Reyes
 * eharoldreyes@gmail.com
 * 
 */
package com.haroldreyes.androidnetworking;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.haroldreyes.androidnetworking.models.FileValuePair;
import com.haroldreyes.androidnetworking.models.Response;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class WebserviceRequest {
			
	public interface Callback {
		public void onResult(int responseCode, String responseMessage, Exception exception);
	}
	
	public static class HttpGET extends AsyncTask<Void, Void, Response>{		

		private Callback callback;
		private ProgressDialog pd;
		private String url;
		private List<BasicNameValuePair> headers;
		private List<BasicNameValuePair> requestHeaders;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			if(pd != null) pd.show();
		}
		
		@Override
		protected Response doInBackground(Void... params) {			
			Response response;
			try {
				HttpResponse httpResponse = WebService.GET(this.url, this.requestHeaders, this.headers);
				response = new Response();
				response.setHttpResponse(httpResponse);			
				response.setResponseCode(response.getHttpResponse().getStatusLine().getStatusCode());
				response.setResponseMesssage(EntityUtils.toString(httpResponse.getEntity()));
				response.setException(null);
				return response;
			} catch (Exception e) {
				response = new Response();
				response.setException(e);
				return response;
			} 
		}
		
		@Override
		protected void onPostExecute(Response result) {
			super.onPostExecute(result);
			if(!result.hasError()){
				try { this.callback.onResult(result.getResponseCode(), result.getResponseMesssage(), result.getException()); } catch (Exception e) { e.printStackTrace(); } 
			}
			if (pd != null && pd.isShowing()) pd.dismiss();			
		}

		public Callback getCallback() {
			return callback;
		}

		public void setCallback(Callback callback) {
			this.callback = callback;
		}

		public ProgressDialog getPd() {
			return pd;
		}

		public void setPd(ProgressDialog pd) {
			this.pd = pd;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<BasicNameValuePair> getHeaders() {
			return headers;
		}

		public void setHeaders(List<BasicNameValuePair> headers) {
			this.headers = headers;
		}

		public List<BasicNameValuePair> getRequestHeaders() {
			return requestHeaders;
		}

		public void setRequestHeaders(List<BasicNameValuePair> requestHeaders) {
			this.requestHeaders = requestHeaders;
		}
	}
	
	public static class HttpPOST extends AsyncTask<Void, Void, Response>{		
		
		private Callback callback;
		private ProgressDialog pd;
		private String url;
		private List<BasicNameValuePair> headers;
		private List<BasicNameValuePair> parameters;
		private List<BasicNameValuePair> requestHeaders;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			if(pd != null) pd.show();
		}
		
		@Override
		protected Response doInBackground(Void... params) {			
			Response response;
			try {
				HttpResponse httpResponse = WebService.POST(this.url, this.requestHeaders, this.headers, this.parameters);
				response = new Response();
				response.setHttpResponse(httpResponse);			
				response.setResponseCode(response.getHttpResponse().getStatusLine().getStatusCode());
				response.setResponseMesssage(EntityUtils.toString(httpResponse.getEntity()));
				response.setException(null);
				return response;
			} catch (Exception e) {
				response = new Response();
				response.setException(e);
				return response;
			} 
		}
		
		@Override
		protected void onPostExecute(Response result) {
			super.onPostExecute(result);
			if(!result.hasError()){
				HttpResponse httpResponse = result.getHttpResponse();
				try { this.callback.onResult(httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()), result.getException()); } catch (Exception e) { e.printStackTrace(); } 
			}
			if (pd != null && pd.isShowing()) pd.dismiss();			
		}		

		public Callback getCallback() {
			return callback;
		}

		public void setCallback(Callback callback) {
			this.callback = callback;
		}

		public ProgressDialog getPd() {
			return pd;
		}

		public void setPd(ProgressDialog pd) {
			this.pd = pd;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<BasicNameValuePair> getHeaders() {
			return headers;
		}

		public void setHeaders(List<BasicNameValuePair> headers) {
			this.headers = headers;
		}
		
		public List<BasicNameValuePair> getParameters() {
			return parameters;
		}

		public void setParameters(List<BasicNameValuePair> parameters) {
			this.parameters = parameters;
		}

		public List<BasicNameValuePair> getRequestHeaders() {
			return requestHeaders;
		}

		public void setRequestHeaders(List<BasicNameValuePair> requestHeaders) {
			this.requestHeaders = requestHeaders;
		}
	}
	
	public static class HttpPUT extends AsyncTask<Void, Void, Response>{		
		
		private Callback callback;
		private ProgressDialog pd;
		private String url;
		private List<BasicNameValuePair> headers;
		private List<BasicNameValuePair> parameters;
		private List<BasicNameValuePair> requestHeaders;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			if(pd != null) pd.show();
		}
		
		@Override
		protected Response doInBackground(Void... params) {			
			
			Response response;
			try {
				HttpResponse httpResponse = WebService.PUT(this.url, this.requestHeaders, this.headers, this.parameters);
				response = new Response();
				response.setHttpResponse(httpResponse);		
				response.setResponseCode(response.getHttpResponse().getStatusLine().getStatusCode());
				response.setResponseMesssage(EntityUtils.toString(httpResponse.getEntity()));
				response.setException(null);
				return response;
			} catch (Exception e) {
				response = new Response();
				response.setException(e);
				return response;
			} 
		}
		
		@Override
		protected void onPostExecute(Response result) {
			super.onPostExecute(result);
			if(!result.hasError()){
				HttpResponse httpResponse = result.getHttpResponse();
				try { this.callback.onResult(httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()), result.getException()); } catch (Exception e) { e.printStackTrace(); } 
			}
			if (pd != null && pd.isShowing()) pd.dismiss();			
		}
		
		public Callback getCallback() {
			return callback;
		}

		public void setCallback(Callback callback) {
			this.callback = callback;
		}

		public ProgressDialog getPd() {
			return pd;
		}

		public void setPd(ProgressDialog pd) {
			this.pd = pd;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<BasicNameValuePair> getHeaders() {
			return headers;
		}

		public void setHeaders(List<BasicNameValuePair> headers) {
			this.headers = headers;
		}
		
		public List<BasicNameValuePair> getParameters() {
			return parameters;
		}

		public void setParameters(List<BasicNameValuePair> parameters) {
			this.parameters = parameters;
		}

		public List<BasicNameValuePair> getRequestHeaders() {
			return requestHeaders;
		}

		public void setRequestHeaders(List<BasicNameValuePair> requestHeaders) {
			this.requestHeaders = requestHeaders;
		}
	}
	
	public static class HttpDELETE extends AsyncTask<Void, Void, Response>{		

		private Callback callback;
		private ProgressDialog pd;
		private String url;
		private List<BasicNameValuePair> headers;
		private List<BasicNameValuePair> requestHeaders;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			if(pd != null) pd.show();
		}
		
		@Override
		protected Response doInBackground(Void... params) {						
			
			Response response;
			try {
				HttpResponse httpResponse = WebService.DELETE(this.url, this.requestHeaders, this.headers);
				response = new Response();
				response.setHttpResponse(httpResponse);				
				response.setResponseCode(response.getHttpResponse().getStatusLine().getStatusCode());
				response.setResponseMesssage(EntityUtils.toString(httpResponse.getEntity()));
				response.setException(null);
				return response;
			} catch (Exception e) {
				response = new Response();
				response.setException(e);
				return response;
			} 
		}
		
		@Override
		protected void onPostExecute(Response result) {
			super.onPostExecute(result);
			if(!result.hasError()){
				HttpResponse httpResponse = result.getHttpResponse();
				try { this.callback.onResult(httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()), result.getException()); } catch (Exception e) { e.printStackTrace(); } 
			}
			if (pd != null && pd.isShowing()) pd.dismiss();			
		}
		
		public Callback getCallback() {
			return callback;
		}

		public void setCallback(Callback callback) {
			this.callback = callback;
		}

		public ProgressDialog getPd() {
			return pd;
		}

		public void setPd(ProgressDialog pd) {
			this.pd = pd;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<BasicNameValuePair> getHeaders() {
			return headers;
		}

		public void setHeaders(List<BasicNameValuePair> headers) {
			this.headers = headers;
		}
		
		public List<BasicNameValuePair> getRequestHeaders() {
			return requestHeaders;
		}

		public void setRequestHeaders(List<BasicNameValuePair> requestHeaders) {
			this.requestHeaders = requestHeaders;
		}
	}
	
	public static class HttpMULTIPARTPOST extends AsyncTask<Void, Void, Response>{		
		
		private Callback callback;
		private ProgressDialog pd;
		private String url;
		private List<BasicNameValuePair> headers;
		private List<BasicNameValuePair> parameters;
		private List<FileValuePair> files;
		private List<BasicNameValuePair> requestHeaders;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			if(pd != null) pd.show();
		}
		
		@Override
		protected Response doInBackground(Void... params) {			
			Response response;
			try {
				HttpResponse httpResponse = WebService.MULTIPARTPOST(this.url, this.requestHeaders, this.headers, this.parameters, this.files);
				response = new Response();
				response.setHttpResponse(httpResponse);			
				response.setResponseCode(response.getHttpResponse().getStatusLine().getStatusCode());
				response.setResponseMesssage(EntityUtils.toString(httpResponse.getEntity()));
				response.setException(null);
				return response;
			} catch (Exception e) {
				response = new Response();
				response.setException(e);
				return response;
			} 
		}
		
		@Override
		protected void onPostExecute(Response result) {
			super.onPostExecute(result);
			if(!result.hasError()){
				HttpResponse httpResponse = result.getHttpResponse();
				try { this.callback.onResult(httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()), result.getException()); } catch (Exception e) { e.printStackTrace(); } 
			}
			if (pd != null && pd.isShowing()) pd.dismiss();			
		}
		
		public Callback getCallback() {
			return callback;
		}

		public void setCallback(Callback callback) {
			this.callback = callback;
		}

		public ProgressDialog getPd() {
			return pd;
		}

		public void setPd(ProgressDialog pd) {
			this.pd = pd;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<BasicNameValuePair> getHeaders() {
			return headers;
		}

		public void setHeaders(List<BasicNameValuePair> headers) {
			this.headers = headers;
		}
		
		public List<BasicNameValuePair> getParameters() {
			return parameters;
		}

		public void setParameters(List<BasicNameValuePair> parameters) {
			this.parameters = parameters;
		}
		
		public List<FileValuePair> getFiles() {
			return files;
		}

		public void setFiles(List<FileValuePair> files) {
			this.files = files;
		}
		
		public List<BasicNameValuePair> getRequestHeaders() {
			return requestHeaders;
		}

		public void setRequestHeaders(List<BasicNameValuePair> requestHeaders) {
			this.requestHeaders = requestHeaders;
		}
	}
	
	public static class HttpMULTIPARTPUT extends AsyncTask<Void, Void, Response>{		
		
		private Callback callback;
		private ProgressDialog pd;
		private String url;
		private List<BasicNameValuePair> headers;
		private List<BasicNameValuePair> parameters;
		private List<FileValuePair> files;
		private List<BasicNameValuePair> requestHeaders;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			if(pd != null) pd.show();
		}
		
		@Override
		protected Response doInBackground(Void... params) {					
			Response response;
			try {
				HttpResponse httpResponse = WebService.MULTIPARTPUT(this.url, this.requestHeaders, this.headers, this.parameters, this.files);
				response = new Response();
				response.setHttpResponse(httpResponse);				
				response.setResponseCode(response.getHttpResponse().getStatusLine().getStatusCode());
				response.setResponseMesssage(EntityUtils.toString(httpResponse.getEntity()));
				response.setException(null);
				return response;
			} catch (Exception e) {
				response = new Response();
				response.setException(e);
				return response;
			} 
		}
		
		@Override
		protected void onPostExecute(Response result) {
			super.onPostExecute(result);
			if(!result.hasError()){
				HttpResponse httpResponse = result.getHttpResponse();
				try { this.callback.onResult(httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()), result.getException()); } catch (Exception e) { e.printStackTrace(); } 
			}
			if (pd != null && pd.isShowing()) pd.dismiss();			
		}
				
		public Callback getCallback() {
			return callback;
		}

		public void setCallback(Callback callback) {
			this.callback = callback;
		}

		public ProgressDialog getPd() {
			return pd;
		}

		public void setPd(ProgressDialog pd) {
			this.pd = pd;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<BasicNameValuePair> getHeaders() {
			return headers;
		}

		public void setHeaders(List<BasicNameValuePair> headers) {
			this.headers = headers;
		}
		
		public List<BasicNameValuePair> getParameters() {
			return parameters;
		}

		public void setParameters(List<BasicNameValuePair> parameters) {
			this.parameters = parameters;
		}
		
		public List<FileValuePair> getFiles() {
			return files;
		}

		public void setFiles(List<FileValuePair> files) {
			this.files = files;
		}
		
		public List<BasicNameValuePair> getRequestHeaders() {
			return requestHeaders;
		}

		public void setRequestHeaders(List<BasicNameValuePair> requestHeaders) {
			this.requestHeaders = requestHeaders;
		}
	}
	
	public static class HttpURLCONNECTION extends AsyncTask<Void, Void, Response>{		
		
		private Callback callback;
		private ProgressDialog pd;
		private String url;
		private List<BasicNameValuePair> headers;
		private String requestMethod;
		private String parameters;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			if(pd != null) pd.show();
		}
		
		@Override
		protected Response doInBackground(Void... params) {					
			return WebService.HttpUrlConnection(this.url, this.requestMethod, this.headers, this.parameters);
		}
		
		@Override
		protected void onPostExecute(Response result) {
			super.onPostExecute(result);
			if(!result.hasError()){
				HttpResponse httpResponse = result.getHttpResponse();
				try { this.callback.onResult(httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()), result.getException()); } catch (Exception e) { e.printStackTrace(); } 
			}
			if (pd != null && pd.isShowing()) pd.dismiss();			
		}
				
		public Callback getCallback() {
			return callback;
		}

		public void setCallback(Callback callback) {
			this.callback = callback;
		}

		public ProgressDialog getPd() {
			return pd;
		}

		public void setPd(ProgressDialog pd) {
			this.pd = pd;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<BasicNameValuePair> getHeaders() {
			return headers;
		}

		public void setHeaders(List<BasicNameValuePair> headers) {
			this.headers = headers;
		}
		
		public String getParameters() {
			return parameters;
		}

		public void setParameters(String parameters) {
			this.parameters = parameters;
		}

		public String getRequestMethod() {
			return requestMethod;
		}

		public void setRequestMethod(String requestMethod) {
			this.requestMethod = requestMethod;
		}
	}
	
}
