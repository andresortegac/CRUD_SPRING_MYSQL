/**
 * 
 */
package com.example.crud.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
*@author DevOrtega
*@version 1.0 9/01/2023
*Clase que representa la entidad Appointment
*/

@Data
@Entity

@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "hour")
	private LocalTime hour;
	
	@Column(name = "id_test")
	private int id_test;
	
	@Column(name = "id_affiliate")
	private int id_affiliate;
}
