/**
 * 
 */
package com.example.crud.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Affiliate;
import com.example.crud.repository.AffiliatesRepository;
import com.example.crud.service.AffiliatesService;

/**
*@author DevOrtega
*@version 1.0 8/01/2023
*Clase que implementa los metodos de lógica de negocio de la interface AffiliatesService
*/

@Service
public class AffiliatesServiceImpl implements AffiliatesService {
	
	/**
	 * Bean AffiliatesRepository de spring inyectado para ejecutar el CRUD
	 */

	@Autowired
	private AffiliatesRepository affiliatesRepository;
	
	
	@Override
	public List<Affiliate> consultarAffiliates() {
		List<Affiliate> affiliatesDataSourse = StreamSupport.stream(this.affiliatesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		return affiliatesDataSourse;
	}


	@Override
	public Affiliate consultarByIdAffiliate(Long id) {
		Optional<Affiliate> optionalAffiliate = affiliatesRepository.findById(id);
		
		if(optionalAffiliate.isPresent()) {
			return optionalAffiliate.get();
		}else {
			return new Affiliate();
		}
	}

}
