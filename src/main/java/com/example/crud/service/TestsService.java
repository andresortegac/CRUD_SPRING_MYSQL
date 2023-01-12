/**
 * 
 */
package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.crud.entity.TestEntity;

/**
*@author DevOrtega
*@version 1.0 14/12/2022
*Interface que contiene los metodos de lógica de negocio para los tests
*/

public interface TestsService {
	
	/**
	*Metodo que permite consultar un listado de tests 
	*@return listado de tests
	*/
	
	List<TestEntity> consultarTests();
	
	/**
	*Metodo que permite consultar por Id un test 
	*@param id {@link Long} objeto test a consultar
	*@return test consultado por id
	*/
	
	TestEntity consultarByIdTest(Long id);
	
	/**
	*Metodo que permite guardar un test 
	*@param testEntity {@link TestEntity} objeto test a guardar
	*@return test guardado
	*/
	
	TestEntity guardarTest(TestEntity testEntity);
	
	/**
	*Metodo que permite actualizar un test 
	*@param testEntity {@link TestEntity} objeto test a actualizar
	*@return test actualizado
	*/
	
	TestEntity actualizarTest(TestEntity testEntity);
	
	/**
	*Metodo que permite eliminar un test 
	*@param id {@link Long} objeto test a eliminar
	*@return test eliminado
	*/
	Optional<TestEntity> findById(Long id);
	
	void eliminarTest(Long id);

}
