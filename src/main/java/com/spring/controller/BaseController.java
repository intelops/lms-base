package com.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.Map;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import com.spring.dto.AddItem;
import com.spring.dto.ApiResponse;
import com.spring.iService.IBaseService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
public class BaseController {
	
	@Autowired
	protected IBaseService service;
	String securityUrl="http://localhost:8765";
		static Logger logger = Logger.getLogger(BaseController.class);
		@Retry(name = "lms",fallbackMethod = "getFallbackRetry")
		@Bulkhead(name = "lms",fallbackMethod = "getFallback", type = Bulkhead.Type.SEMAPHORE)
		//@HystrixCommand(fallbackMethod = "getFallback")
		@CircuitBreaker(name = "lms", fallbackMethod = "getFallbackTimeout")
		public String validateToken(String token,String role) {
			String responseJson=null;
			try {
				
				WebClient webClient = WebClient.create(securityUrl);
				 
				responseJson = webClient.get()
				        .uri("/token/validate-token?token={token}&role={role}",token,role)
				       .exchange()
						.block()
						.bodyToMono(String.class)
						.block();

			}
			catch (Exception e) {
				String stackTrace = ExceptionUtils.getStackTrace(e);
				logger.error(stackTrace);

			}
			return responseJson;
		}
		@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
		@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
		//@HystrixCommand(fallbackMethod = "userFallback")
		@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
		public ResponseEntity<ApiResponse> addTocart(AddItem cartDto) {
			ResponseEntity<ApiResponse> result=null;
			try {
				WebClient webClient = WebClient.create("http://localhost:8011");
				
				result = webClient.post()
						.uri("/api/addToCart")
		                .accept(MediaType.APPLICATION_JSON)
		                .bodyValue(cartDto).retrieve().bodyToMono(ResponseEntity.class).block();
			}
			catch (Exception e) {
				String stackTrace = ExceptionUtils.getStackTrace(e);
				logger.error(stackTrace);

			}
			return result;


		}
		@Retry(name = "lms",fallbackMethod = "getFallbackRetry")
		@Bulkhead(name = "lms",fallbackMethod = "getFallback", type = Bulkhead.Type.SEMAPHORE)
	//	@HystrixCommand(fallbackMethod = "getFallback")
		@CircuitBreaker(name = "lms", fallbackMethod = "getFallbackTimeout")
		public String getUserById(String token,String role) {
			String responseJson=null;
			try {
				
				WebClient webClient = WebClient.create(securityUrl);
				 
				responseJson = webClient.get()
				        .uri("/token/validate-token?token={token}&role={role}",token,role)
				       .exchange()
						.block()
						.bodyToMono(String.class)
						.block();

			}
			catch (Exception e) {
				String stackTrace = ExceptionUtils.getStackTrace(e);
				logger.error(stackTrace);

			}
			return responseJson;
		}
		@Retry(name = "lms",fallbackMethod = "getFallbackRetry")
		@Bulkhead(name = "lms",fallbackMethod = "getFallback", type = Bulkhead.Type.SEMAPHORE)
		//@HystrixCommand(fallbackMethod = "getFallback")
		@CircuitBreaker(name = "lms", fallbackMethod = "getFallbackTimeout")
		public int getIdByUser(String token) {
			int responseJson=0;
			try {
				
				WebClient webClient = WebClient.create(securityUrl);
				 
				responseJson = webClient.get()
				        .uri("/token/getUserId?token={token}",token)
				       .exchange()
						.block()
						.bodyToMono(Integer.class)
						.block();
System.out.println("....");
			}
			catch (Exception e) {
				String stackTrace = ExceptionUtils.getStackTrace(e);
				logger.error(stackTrace);

			}
			return responseJson;
		}
		public Map<String, Object> getDropDownData()throws SQLException  {

			Map<String, Object> list =null;
			try {
					list = service.getDropDownData();
				}
				
			
			catch (Exception e) {

				String stackTrace = ExceptionUtils.getStackTrace(e);
				logger.error(stackTrace);
				
			}
			return list;
		}
		
		@SuppressWarnings({ "unused" })
		private String validateTokenFallback(String token,String role,Throwable throwable) {
			logger.info("validateTokenFallback invoked");
			return "Falling back : " + token;
		}
		@SuppressWarnings({ "unused"})
		private String validateTokenFallbackRetry(String token,String role,HttpClientErrorException throwable) {
			logger.info("validateTokenFallbackRetry invoked");
			return "Falling back Retry: " + token;
		}

}
