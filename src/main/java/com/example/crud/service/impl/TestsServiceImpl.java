
package com.example.crud.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.crud.entity.TestEntity;
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
	public List<TestEntity> consultarTests() {
		List<TestEntity> testsDataSourse =StreamSupport.stream(this.testsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		return testsDataSourse;
	}

	@Override
	public TestEntity consultarByIdTest(Long id) {
		Optional<TestEntity> optionalTest = testsRepository.findById(id);
		
		if(optionalTest.isPresent()) {
			return optionalTest.get();
		}else {
			return null;
		}	
		
	}

	@Override
	public TestEntity guardarTest(TestEntity testEntity) {
		
		return this.testsRepository.save(testEntity);
	}

	@Override
	public TestEntity actualizarTest(TestEntity testEntity) {
		return this.testsRepository.save(testEntity);
	}

	@Override
	public void eliminarTest(Long id) {
		
        testsRepository.deleteById(id);
	}

	@Override
	public Optional<TestEntity> findById(Long id) {
		return testsRepository.findById(id);
	}

}
