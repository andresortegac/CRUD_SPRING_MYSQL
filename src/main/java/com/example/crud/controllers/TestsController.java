/**
 * 
 */
package com.example.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Test;
import com.example.crud.service.TestsService;

/**
*@author DevOrtega
*@version 1.0 14/12/2022
*Controlador que manipula el flujo de los servicios rest del microservicio de test
*/
@RestController
@RequestMapping("/tests")
public class TestsController {
	
	@Autowired
	private TestsService testsServiceImpl;
	
	@GetMapping
	@RequestMapping(value = "consultarTests", method = RequestMethod.GET)
    
	public ResponseEntity<?> consultarTests(){
		
		List<Test> testsConsultados = this.testsServiceImpl.consultarTests();
		
		return ResponseEntity.ok(testsConsultados); 
	}
}
