/**
 * 
 */
package com.example.crud.service;

import java.util.List;

import com.example.crud.entity.Affiliate;


/**
*@author DevOrtega
*@version 1.0 8/01/2023
*Interface que contiene los metodos de lógica de negocio para los affiliates
*/
public interface AffiliatesService {
	/**
	*Metodo que permite consultar un listado de affiliates 
	*@return listado de affiliates 
	*/
	
	List<Affiliate> consultarAffiliates();
}
