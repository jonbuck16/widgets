package com.example.widgets.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/widgets", produces = "application/json")
@Api(tags = {"Widgets"})
public class WidgetController {

	/**
	 * 
	 */
	@ApiOperation(value="List Widgets", notes = "Returns a complete list of all widgets")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = ""),
			@ApiResponse(code = 500, message = "Widgets could not be retrieved")
	})
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public void listAllWidgets() {
		
	}
	
}
