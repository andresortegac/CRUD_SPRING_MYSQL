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

import com.example.crud.entity.Affiliate;
import com.example.crud.service.AffiliatesService;

/**
*@author DevOrtega
*@version 1.0 8/01/2023
*Controlador que manipula el flujo de los servicios rest del microservicio de affiliates
*/

@RestController
@RequestMapping("/affiliates")
public class AffiliatesController {
	
	@Autowired
	private AffiliatesService affiliatesServiceImpl;
	
	
	@GetMapping
	@RequestMapping(value = "consultarAffiliates", method = RequestMethod.GET)	
	
    
	public ResponseEntity<?> consultarAffiliates(){
		
		List<Affiliate> affiliatesConsultados = this.affiliatesServiceImpl.consultarAffiliates();
		
		return ResponseEntity.ok(affiliatesConsultados); 
	}
	

}
