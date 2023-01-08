/**
 * 
 */
package com.example.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.crud.entity.Test;

/**
*@author DevOrtega
*@version 1.0 14/12/2022
*Interface que contiene el CRUD con Spring JPA para la tabla tests
*/

public interface TestsRepository extends CrudRepository<Test, Long> {

}







