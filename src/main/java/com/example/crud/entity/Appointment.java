/**
 * 
 */
package com.example.crud.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*@author DevOrtega
*@version 1.0 9/01/2023
*Clase que representa la entidad Appointment
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "hour")
	private String hour;
	
	@ManyToOne
	@JoinColumn(name = "id_test")
	private TestEntity testEntity;
	
	@ManyToOne
	@JoinColumn(name = "id_affiliate")
	private Affiliate affiliate;
}
