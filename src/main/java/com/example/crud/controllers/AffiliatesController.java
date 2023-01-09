/**
 * 
 */
package com.example.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Affiliate;
import com.example.crud.entity.Test;
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
	
	@GetMapping("/consultarByIdAffiliate/{id}")
	
	public Affiliate consultarByIdAffiliate(@PathVariable Long id){		
		
		return affiliatesServiceImpl.consultarByIdAffiliate(id); 
	}
	
	@PostMapping()
	@RequestMapping(value = "guardarAffiliate", method = RequestMethod.POST)	
    
	public ResponseEntity<?> guardarAffiliate(@RequestBody Affiliate affiliate){	
		
		Affiliate affiliateGuardado = this.affiliatesServiceImpl.guardarAffiliate(affiliate);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(affiliateGuardado);
		
	}
	
	@PutMapping()
	@RequestMapping(value = "actualizarAffiliate", method = RequestMethod.PUT)	
    
	public ResponseEntity<?> actualizarAffiliate(@RequestBody Affiliate affiliate){	
		
		Affiliate affiliateActualizado = this.affiliatesServiceImpl.actualizarAffiliate(affiliate);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(affiliateActualizado);
		
	}

}
