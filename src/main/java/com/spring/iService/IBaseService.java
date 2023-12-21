package com.spring.iService;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.spring.dto.DataDto;
import com.spring.dto.DropDownData;
import com.spring.dto.DropDownDataDto;
import com.spring.dto.LmsResponse;
import com.spring.model.UserDto;

public interface IBaseService {
	public UserDto getUserById(int userId);

	public Map<String, Object> getDropDownData();

	public ResponseEntity<DropDownDataDto> getDropDownSetupData();

}
