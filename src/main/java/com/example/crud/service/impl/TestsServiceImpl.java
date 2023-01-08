
package com.example.crud.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Test;
import com.example.crud.repository.TestsRepository;
import com.example.crud.service.TestsService;
/**
*@author DevOrtega
*@version 1.0 14/12/2022
*Clase que implementa los metodos de lógica de negocio de la interface TestsService
*/

@Service
public class TestsServiceImpl implements TestsService {
	
	/**
	 * Bean TestsRepository de spring inyectado para ejecutar el CRUD
	 */
	
	@Autowired
	private TestsRepository testsRepository;

	@Override
	public List<Test> consultarTests() {
		List<Test> testsDataSourse =StreamSupport.stream(this.testsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		return testsDataSourse;
	}

	@Override
	public Test consultarByIdTest(Long id) {
		Optional<Test> optionalTest = testsRepository.findById(id);
		
		if(optionalTest.isPresent()) {
			return optionalTest.get();
		}else {
			return new Test();
		}	
		
	}

	@Override
	public Test guardarTest(Test test) {
		
		return this.testsRepository.save(test);
	}

}
