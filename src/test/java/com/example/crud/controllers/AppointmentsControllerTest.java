package com.example.crud.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.web.servlet.ResultActions;

import com.example.crud.entity.Affiliate;
import com.example.crud.entity.Appointment;
import com.example.crud.entity.TestEntity;
import com.example.crud.service.AppointmentsService;

class AppointmentsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AppointmentsService appointmentsService;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testConsultarAppointments() throws Exception {
		
		//given
        List<Appointment> listaAppointments = new ArrayList<>();
        listaAppointments.add(Appointment.builder().date("2023-01-11").hour("12:48:13").build());
        listaAppointments.add(Appointment.builder().date("2023-03-11").hour("13:48:13").build());
        given(appointmentsService.consultarAppointments()).willReturn(listaAppointments);

        //when
        ResultActions response = mockMvc.perform(get("/appointments/consultarAppointments"));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",is(listaAppointments.size())));
	}

	@Test
	void testConsultarByIdAppointment() throws Exception {
		
		//given
        long id = 1L;
        Appointment appointment = Appointment.builder()
                .date("2023-01-11")
                .hour("12:48:13")
                .build();
        given(appointmentsService.consultarByIdAppointment(id)).willReturn(appointment);

        //when
        ResultActions response = mockMvc.perform(get("/appointments/consultarByIdAppointment/{id}",id));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.nombre",is(appointment.getDate())))
                .andExpect(jsonPath("$.apellido",is(appointment.getHour())));
	}

	@Test
	void testGuardarAppointment() throws Exception {
		//given
		
		Appointment appointment = Appointment.builder()
				.date("2023-01-11")
                .hour("12:48:13")
                .build();
		given(appointmentsService.guardarAppointment(any(Appointment.class))).willAnswer((invocation)->invocation.getArgument(0));
		
		//when
		
		ResultActions response = mockMvc.perform(post("/appointments/guardarAppointment")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(appointment)));
		
		//then
		response.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.nombre",is(appointment.getDate())))
                .andExpect(jsonPath("$.apellido",is(appointment.getHour())));
	}

	@Test
	void testActualizarAppointment() throws Exception {
		//given
        long id = 1L;
        Appointment appointmentGuardado = Appointment.builder()
        		.date("2023-01-11")
                .hour("12:48:13")
                .build();

        Appointment appointmentActualizado = Appointment.builder()
        		.date("2023-01-11")
                .hour("12:48:13")
                .build();

        given(appointmentsService.consultarByIdAppointment(id)).willReturn(appointmentGuardado);
        given(appointmentsService.actualizarAppointment(any(Appointment.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(put("/appointments/actualizarAppointment/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointmentActualizado)));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name",is(appointmentActualizado.getDate())))
                .andExpect(jsonPath("$.age",is(appointmentActualizado.getHour())));
	}

	@Test
	void testEliminarAppointment() throws Exception {
		//given
        long id = 1L;
        willDoNothing().given(appointmentsService).eliminarAppointment(id);

        //when
        ResultActions response = mockMvc.perform(delete("/appointments/eliminarAppointment/{id}",id));

        //then
        response.andExpect(status().isOk())
                .andDo(print());
	}

}
