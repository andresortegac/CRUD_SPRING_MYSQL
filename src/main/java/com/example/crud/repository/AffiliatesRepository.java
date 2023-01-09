/**
 * 
 */
package com.example.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.crud.entity.Affiliate;

/**
*@author DevOrtega
*@version 1.0 8/01/2023
*Interface que contiene el CRUD con Spring JPA para la tabla affiliates
*/

public interface AffiliatesRepository extends CrudRepository<Affiliate, Long>{

}
