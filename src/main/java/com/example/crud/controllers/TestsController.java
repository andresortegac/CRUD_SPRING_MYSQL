/**
 * 
 */
package com.example.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping("/consultarByIdTest/{id}")
	
	public Test consultarByIdTest(@PathVariable Long id){		
		
		return testsServiceImpl.consultarByIdTest(id); 
	}
	
	@PostMapping()
	@RequestMapping(value = "guardarTest", method = RequestMethod.POST)	
    
	public ResponseEntity<?> guardarTest(@RequestBody Test test){	
		
		Test testGuardado = this.testsServiceImpl.guardarTest(test);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(testGuardado);
		
	}
	
	@PutMapping()
	@RequestMapping(value = "actualizarTest", method = RequestMethod.PUT)	
    
	public ResponseEntity<?> actualizarTest(@RequestBody Test test){	
		
		Test testActualizado = this.testsServiceImpl.actualizarTest(test);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(testActualizado);
		
	}
	
	@DeleteMapping()
	@RequestMapping(value = "eliminarTest/{id}", method = RequestMethod.DELETE)	
    
	public ResponseEntity<?> eliminarTest(@PathVariable Long id){	
		
		this.testsServiceImpl.eliminarTest(id);
		
		return ResponseEntity.ok().build();
		
	}
}
