/**
 * 
 */
package com.example.crud.service;

import java.util.List;

import com.example.crud.entity.Test;

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
	
	List<Test> consultarTests();
	
	/**
	*Metodo que permite consultar por Id un test 
	*@param id {@link Long} objeto test a consultar
	*@return test consultado por id
	*/
	
	Test consultarByIdTest(Long id);
	
	/**
	*Metodo que permite guardar un test 
	*@param test {@link Test} objeto test a guardar
	*@return test guardado
	*/
	
	Test guardarTest(Test test);
	
	/**
	*Metodo que permite actualizar un test 
	*@param test {@link Test} objeto test a actualizar
	*@return test actualizado
	*/
	
	Test actualizarTest(Test test);
	
	/**
	*Metodo que permite eliminar un test 
	*@param id {@link Long} objeto test a eliminar
	*@return test eliminado
	*/
	
	void eliminarTest(Long id);

}
