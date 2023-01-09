/**
 * 
 */
package com.example.crud.service;

import java.util.List;

import com.example.crud.entity.Affiliate;
import com.example.crud.entity.Test;


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
	
	/**
	*Metodo que permite consultar por Id un affiliate 
	*@param id {@link Long} objeto affiliate a consultar
	*@return affiliate consultado por id
	*/
	
	Affiliate consultarByIdAffiliate(Long id);
	
	/**
	*Metodo que permite guardar un affiliate 
	*@param affiliate {@link Affiliate} objeto affiliate a guardar
	*@return test guardado
	*/
	
	Affiliate guardarAffiliate(Affiliate affiliate);
	
	/**
	*Metodo que permite actualizar un affiliate 
	*@param affiliate {@link Affiliate} objeto affiliate a actualizar
	*@return affiliate actualizado
	*/
	
	Affiliate actualizarAffiliate(Affiliate affiliate);
}
