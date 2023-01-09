/**
 * 
 */
package com.example.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
*@author DevOrtega
*@version 1.0 8/01/2023
*Clase que representa la entidad Affiliate
*/

@Data
@Entity

@Table(name = "affiliates")
public class Affiliate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "mail")
	private String mail;

}
