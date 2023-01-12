/**
 * 
 */
package com.example.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.TestEntity;

/**
*@author DevOrtega
*@version 1.0 14/12/2022
*Interface que contiene el CRUD con Spring JPA para la tabla tests
*/

@Repository
public interface TestsRepository extends CrudRepository<TestEntity, Long> {

}







