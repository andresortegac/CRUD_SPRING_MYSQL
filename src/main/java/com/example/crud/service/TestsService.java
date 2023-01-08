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

}
