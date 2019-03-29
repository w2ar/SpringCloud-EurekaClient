package com.cloud.eureka.client.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TestRest {

	@Value("${server.port}")
	private String port;

	@Value("${config.val}")
	private String configVal;
	/**
	 * 
	 */
	@GetMapping(value = "client/{value}", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String testFunction(@PathVariable(value = "value", required = true) String value) {

		return port + ", Config: " + configVal + " : 測試EurekaCleint --> " + value;
	}
}
