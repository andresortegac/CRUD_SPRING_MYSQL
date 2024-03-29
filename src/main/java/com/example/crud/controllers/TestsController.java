/**
 * 
 */
package com.example.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.TestEntity;
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
		
		List<TestEntity> testsConsultados = this.testsServiceImpl.consultarTests();
		
		if (testsConsultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(testsConsultados);
        }
		
	} 
	
	@GetMapping("/consultarByIdTest/{id}")
	
	public ResponseEntity<TestEntity> consultarByIdTest(@PathVariable Long id){	
		
		TestEntity testConsultadoById = testsServiceImpl.consultarByIdTest(id); 
		
		if(testConsultadoById == null){
            return new ResponseEntity<>(testConsultadoById, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(testConsultadoById, HttpStatus.OK);
        }
	}
	
	@PostMapping()
	@RequestMapping(value = "guardarTest", method = RequestMethod.POST)	
    
	public ResponseEntity<TestEntity> guardarTest(@RequestBody TestEntity testEntity){	
		
		TestEntity testGuardado = this.testsServiceImpl.guardarTest(testEntity);	
		
		if(testGuardado==null){
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }else{
	        return new ResponseEntity<>(testGuardado, HttpStatus.CREATED);
	    }
		
	}
	
	@PutMapping()
	@RequestMapping(value = "actualizarTest", method = RequestMethod.PUT)	
    
	public ResponseEntity<?> actualizarTest(@RequestBody TestEntity testEntity){	
		
		TestEntity testActualizado = this.testsServiceImpl.actualizarTest(testEntity);
		
		if(testActualizado!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(testActualizado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
		
		
	}
	
	@DeleteMapping()
	@RequestMapping(value = "eliminarTest/{id}", method = RequestMethod.DELETE)	
    
	public ResponseEntity<?> eliminarTest(@PathVariable Long id){		
		
		Optional<TestEntity> element = testsServiceImpl.findById(id);

	    if (!element.isPresent()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    testsServiceImpl.eliminarTest(id);
	    
	    return ResponseEntity.ok().build();
        
		
		
		
	}
}
