package com.spring.service;
import com.spring.dto.DropDownDataDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.BaseDao.IGenericDao;
import com.spring.dto.AddItem;
import com.spring.dto.AllCourseRequest;
import com.spring.dto.ApiResponse;
import com.spring.dto.CheckoutDto;
import com.spring.dto.CheckoutItemDto;
import com.spring.dto.CourseRequest;
import com.spring.dto.DataDto;
import com.spring.dto.DropDownData;
import com.spring.dto.LmsResponse;
import com.spring.dto.MyResponse;
import com.spring.iService.IBaseService;

import com.spring.model.ConfigMaster;
import com.spring.model.ConfigSlave;
import com.spring.model.Email;
import com.spring.model.Sms;

import com.spring.model.UserDto;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service(value = "baseService")
@Primary
public class BaseServiceImpl implements IBaseService {

	 private static final int DropDownData = 0;

	@SuppressWarnings("rawtypes")
		@Autowired
		protected IGenericDao genericDao;
	  
	static Logger logger = Logger.getLogger(BaseServiceImpl.class);
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public UserDto getUserById(int userId) {
		UserDto result=null;
		try {
			WebClient webClient = WebClient.create("http://localhost:8082");
			result = webClient.get()
					.uri("/token/getUserById?userId="+userId)
					.exchange()
					.block()
					.bodyToMono(UserDto.class)
					.block();
		}
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public MyResponse getNoOfUsers(CourseRequest req) {
		ResponseEntity<MyResponse> result=null;
		try {
			//CourseRequest req=new CourseRequest();
			//req.setBatchId(batchId);
			RestTemplate restTemplate = new RestTemplate();
			result=restTemplate.postForEntity("http://localhost:8082/token/getNoOfUsers",req, MyResponse.class);
		}
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result.getBody();


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public MyResponse getNoOfByAdmin(CourseRequest req) {
		ResponseEntity<MyResponse> result=null;
		try {
			//CourseRequest req=new CourseRequest();
			//req.setBatchId(batchId);
			RestTemplate restTemplate = new RestTemplate();
			result=restTemplate.postForEntity("http://localhost:8082/token//getNoOfStudents",req, MyResponse.class);
		}
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result.getBody();


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<LmsResponse> getAllCourse(CourseRequest req) {
		ResponseEntity<LmsResponse> result=null;
		//CourseRequest req=new CourseRequest();
//JSONObject json=new JSONObject();
		try {
			//req.setCourse(course);
			//json.put("course",course);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8090/api/getAllCoursesBySearch",req, LmsResponse.class);
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<LmsResponse> getCourseById(int course) {
		ResponseEntity<LmsResponse> result=null;
		 // response=new HashMap<String, Object>();
		CourseRequest req=new CourseRequest();
//JSONObject json=new JSONObject();
		try {
			req.setCourse(course);
			//json.put("course",course);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8090/api/getCourseById",req, LmsResponse.class);
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<DropDownDataDto> getDropDownSetupData() {
		//ResponseEntity<LmsResponse> result=null;
		 // response=new HashMap<String, Object>();
		
//JSONObject json=new JSONObject();
	//	try {
			
			//json.put("course",course);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			ResponseEntity<DropDownDataDto> result=restTemplate.getForEntity("http://localhost:8090/api/getDropDownData",DropDownDataDto.class);
		//}
		
		//catch (Exception e) {
		///String stackTrace = ExceptionUtils.getStackTrace(e);
		//	logger.error(stackTrace);

		//}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<LmsResponse> getCourseTopic(int courseTopicId) {
		ResponseEntity<LmsResponse> result=null;
		 // response=new HashMap<String, Object>();
		CourseRequest req=new CourseRequest();
//JSONObject json=new JSONObject();
		try {
			req.setCourseTopic(courseTopicId);
			//json.put("course",course);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8090/api/getCourseTopic",req, LmsResponse.class);
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<MyResponse> getAllPurchased(int userId) {
		ResponseEntity<MyResponse> result=null;
		CourseRequest req=new CourseRequest();
//JSONObject json=new JSONObject();
		try {
			req.setInstitute(userId);
			//json.put("userId",userId);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			result =
			     //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                //   HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8092/payment/getAllPurchasedCourses",req,MyResponse.class);
			
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return 
				result;
		


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<MyResponse> getAllHighestCourse(int userId) {
		ResponseEntity<MyResponse> result=null;
		//CourseRequest req=new CourseRequest();
JSONObject json=new JSONObject();
		try {
			//req.setInstitute(userId);
			json.put("userId",userId);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			result =
			     //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                //   HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8082/token/getBatchMembersHighestPurchasedCourses",json,MyResponse.class);
			
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return 
				result;
		


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<JSONObject> getAllCoursesBycategory(Set<Integer> set) {
		ResponseEntity<JSONObject> result=null;
		//CourseRequest req=new CourseRequest();
//JSONObject json=new JSONObject();
		try {
			//req.setCourse(course);
			//json.put("course",course);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8090/api/getAllPurchasedCoursesByCategory",set,JSONObject.class);
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<LmsResponse> getAllCoursesDurationList(Set<Integer> set) {
		ResponseEntity<LmsResponse> result=null;
		//CourseRequest req=new CourseRequest();
//JSONObject json=new JSONObject();
		try {
			//req.setCourse(course);
			//json.put("course",course);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8090/api/getAllCoursesDuration",set,LmsResponse.class);
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<LmsResponse> getAllCoursesCategory() {
		ResponseEntity<LmsResponse> result=null;
		//CourseRequest req=new CourseRequest();
//JSONObject json=new JSONObject();
		try {
			//req.setCourse(course);
			//json.put("course",course);
			
			RestTemplate restTemplate = new RestTemplate();
			WebClient webClient = WebClient.create("http://localhost:8090");
			result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	//restTemplate.postForEntity("http://localhost:8090/api/getAllCategories",LmsResponse.class);
			//WebClient webClient = WebClient.create("http://localhost:8090");
			
			result = webClient.post()
					.uri("/api/getAllCategories")
	                .accept(MediaType.APPLICATION_JSON)
	                .retrieve().bodyToMono(ResponseEntity.class).block();
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<LmsResponse> getAllapplyRecommendationAlgorithm(Set<Integer> set) {
		ResponseEntity<LmsResponse> result=null;
		//CourseRequest req=new CourseRequest();
//JSONObject json=new JSONObject();
		try {
			//req.setCourse(course);
			//json.put("course",course);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8090/api/applyRecommendationAlgorithm",set,LmsResponse.class);
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<Integer> getUserDuration(CourseRequest reqs) {
		ResponseEntity<Integer> result=null;
		//CourseRequest req=new CourseRequest();
//JSONObject json=new JSONObject();
		try {
			//req.setCourse(course);
			//json.put("course",course);
			
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8090/api/getAllCoursesDuration",reqs,Integer.class);
		}
		
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public List<UserDto> getUsers() {
		List<UserDto> result=null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			ResponseEntity<List<UserDto>> rateResponse =
			        restTemplate.exchange("http://localhost:8082/user/getUser",
			                    HttpMethod.GET,null, new ParameterizedTypeReference<List<UserDto>>() {
			            });
			 result = rateResponse.getBody();
			//result = restTemplate.exchange(url, HttpMethod.POST, requestEntity,new ParameterizedTypeReference<List<Person>>() {});
		}
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		return result;


	}
	@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public void createUser(UserDto user) {
		ResponseEntity<?> result=null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			//WebClient webClient = WebClient.create("http://localhost:8082");
			ResponseEntity<JSONObject> rateResponse =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8082/token/createUser", user, JSONObject.class);
			// result = rateResponse;
			//result = restTemplate.exchange(url, HttpMethod.POST, requestEntity,new ParameterizedTypeReference<List<Person>>() {});
		}
		catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
	//	return result;


	}
	/*webClient.post()
	.uri("/user/getUsers")
	.exchange()
	.block()
	.bodyToMono(List.class)
	.block();*/
@SuppressWarnings("unchecked")
@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
	@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
	//@HystrixCommand(fallbackMethod = "userFallback")
	@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
	public ResponseEntity<ApiResponse>  sendSms(Sms sms) {
	ResponseEntity<ApiResponse>  result=null;
		try {
			//RestTemplate restTemplate = new RestTemplate();
			/*WebClient webClient = WebClient.create("http://localhost:8089");
			
			ResponseEntity<ApiResponse>  result = webClient.post()
					.uri("/send/sendSMS")
	                .accept(MediaType.APPLICATION_JSON)
	                .bodyValue(sms).retrieve().bodyToMono(ResponseEntity.class).block();*/
			RestTemplate restTemplate = new RestTemplate();
	result =
				      //  restTemplate.exchange("http://localhost:8082/token/createUser",
				                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
				        	restTemplate.postForEntity("http://localhost:8089/send/sendSMS",sms,ApiResponse.class);
			///return result;

			//if(result!=null) {
			//return result;
			//}
			//else {
				//return null;
			//}
			
		}
	catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			logger.error(stackTrace);

		}
		//System.out.println("................"+result.getBody().getMessage());
		return result;


	}
@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
//@HystrixCommand(fallbackMethod = "userFallback")
@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
public String createSession(CheckoutDto checkoutItem) {
	String sessionId=null;
	try {
		WebClient webClient = WebClient.create("http://localhost:8089");
		
		ResponseEntity<ApiResponse> result = webClient.post()
				.uri("/external/createSessionId")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(checkoutItem).retrieve().bodyToMono(ResponseEntity.class).block();
		sessionId=result.getBody().getMessage();
	}
	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);

	}
	return sessionId;


}
@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
//@HystrixCommand(fallbackMethod = "userFallback")
@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
public ResponseEntity<ApiResponse> addTocart(AddItem cartDto) {
	ResponseEntity<ApiResponse> result=null;
	try {
		WebClient webClient = WebClient.create("http://localhost:8093");
		
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
@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
//@HystrixCommand(fallbackMethod = "userFallback")
@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
public ResponseEntity<LmsResponse> getCartItems(int userId) {
	ResponseEntity<LmsResponse> result=null;
	JSONObject json=new JSONObject();
	try {
		//WebClient webClient = WebClient.create("http://localhost:8015");
		json.put("userId",userId);
		RestTemplate restTemplate = new RestTemplate();

		result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8093/cart/getAllItemsInCart",json,LmsResponse.class);
	
	}
	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);
		System.out.println(stackTrace);
		//return new ResponseEntity<LMSResponse>(new LMSResponse(false, "service failed due to some exceptions", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

	}
	return result;


}
@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
//@HystrixCommand(fallbackMethod = "userFallback")
@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
public ResponseEntity<LmsResponse> getWishlistItems(int userId) {
	ResponseEntity<LmsResponse> result=null;
	JSONObject json=new JSONObject();
	try {
	//	WebClient webClient = WebClient.create("http://localhost:8029");
		json.put("userId",userId);
		RestTemplate restTemplate = new RestTemplate();

		result =
			      //  restTemplate.exchange("http://localhost:8082/token/createUser",
			                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
			        	restTemplate.postForEntity("http://localhost:8094/wish/getAllItemsFromWishList",json,LmsResponse.class);
	
	}
	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);

	}
	return result;


}
@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
//@HystrixCommand(fallbackMethod = "userFallback")
@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
public ResponseEntity<ApiResponse> removeAllItemsFromcart(int userId) {
	ResponseEntity<ApiResponse> result=null;
	try {
		WebClient webClient = WebClient.create("http://localhost:8093");
		JSONObject json=new JSONObject();
		json.put("userId",userId);
		result = webClient.post()
				.uri("/cart/removeAllItemsFromcart")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(json).retrieve().bodyToMono(ResponseEntity.class).block();
	}
	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);

	}
	return result;


}
@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
//@HystrixCommand(fallbackMethod = "userFallback")
@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
public Map<String,Object> getPlan(int userId) {
	Map<String,Object> result=null;
	JSONObject json=new JSONObject();
	JSONObject response=new JSONObject();
	
	try {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper oMapper = new ObjectMapper();

		json.put("userId",userId);
		System.out.println(json);
	//	WebClient webClient = WebClient.create("http://localhost:8088");
		ResponseEntity<JSONObject> list =
		       restTemplate.postForEntity("http://localhost:8097/plan/getAllPlans",
		            json,JSONObject.class);
		//restTemplate.postForEntity(append_url,request,JSONObject.class);
		/*ResponseEntity<Map<String,Object>> list = webClient.post()
				.uri("/api/getCustomizePlan")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(json).retrieve().bodyToMono(ResponseEntity.class).block();
		System.out.println("list:"+list);*/
		response=list.getBody();
	//	result=response.get("list");
		
		result=oMapper.convertValue(response.get("list"), Map.class);
	}
	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);

	}
	return result;


}
@Retry(name = "lms",fallbackMethod = "userFallbackRetry")
@Bulkhead(name = "lms",fallbackMethod = "userFallback", type = Bulkhead.Type.SEMAPHORE)
//@HystrixCommand(fallbackMethod = "userFallback")
@CircuitBreaker(name = "lms", fallbackMethod = "userFallback")
public ResponseEntity<ApiResponse>  sendEmail(Email email) {
	ResponseEntity<ApiResponse>  result=null;
	try {
		/*WebClient webClient = WebClient.create("http://localhost:8089");
		result = webClient.post()
				.uri("/send/sendEmail")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(email).retrieve().bodyToMono(ResponseEntity.class).block();
        .bodyValue(sms).retrieve().bodyToMono(ResponseEntity.class).block();*/
			RestTemplate restTemplate = new RestTemplate();
	result =
				      //  restTemplate.exchange("http://localhost:8082/token/createUser",
				                    //HttpMethod.POST,user, new ParameterizedTypeReference<JSONObject>() ;
				        	restTemplate.postForEntity("http://localhost:8089/send/sendEmail",email,ApiResponse.class);
			
	}
	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);

	}
	return result;


}

@SuppressWarnings("unchecked")
@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
@Override
public Map<String, Object> getDropDownData() {
	try {
		genericDao.setClazz(ConfigMaster.class);
		List<ConfigMaster> configList= genericDao.findAll();
		if(configList!=null) {
			Map<String, Object> response = new HashMap<String, Object>();
			for (ConfigMaster configMaster: configList) {

				String key=configMaster.getKey();
				List<ConfigSlave> list=configMaster.getConfigSlave();
				response.put(key, list);
			}

			return response;
		}
		else {
			return new HashMap<String, Object>();
		}
	}
	catch (Exception e) {
		throw e;
	}

}
	@SuppressWarnings({ "unused", "unchecked" })
	private UserDto userFallback(int userId,Throwable throwable) {
		logger.info("userFallback invoked");
		return new UserDto();
	}
	@SuppressWarnings({ "unused", "unchecked" })
	private UserDto userFallbackRetry(int userId,HttpClientErrorException throwable) {
		logger.info("userFallbackRetry invoked");
		return new UserDto();
	}


}
