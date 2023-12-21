package com.spring.dto;

import java.util.Map;

import org.json.JSONObject;

import com.google.gson.JsonObject;

public class ApiResponse1 {
	  private String url;
	    private JsonObject requestParams;
	    private JsonObject responseData;

	    public String getUrl() {
	        return url;
	    }

	    public void setUrl(String url) {
	        this.url = url;
	    }

		public JsonObject getRequestParams() {
			return requestParams;
		}

		public void setRequestParams(JsonObject requestParams) {
			this.requestParams = requestParams;
		}

		public JsonObject getResponseData() {
			return responseData;
		}

		public void setResponseData(JsonObject responseData) {
			this.responseData = responseData;
		}

		

	   
}
