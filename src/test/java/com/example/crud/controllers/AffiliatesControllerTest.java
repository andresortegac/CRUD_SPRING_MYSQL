package com.example.crud.controllers;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.crud.entity.TestEntity;
import com.example.crud.service.TestsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.crud.entity.Affiliate;
import com.example.crud.service.AffiliatesService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class AffiliatesControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private AffiliatesService affiliatesService;

    @Autowired
    private ObjectMapper objectMapper;

	@Test
	void testConsultarAffiliates() throws Exception {
		
		//given
        List<Affiliate> listaAffiliates = new ArrayList<>();
        listaAffiliates.add(Affiliate.builder().name("name1").age(25).mail("name1gmail.com").build());
        listaAffiliates.add(Affiliate.builder().name("name2").age(35).mail("name2gmail.com").build());
        listaAffiliates.add(Affiliate.builder().name("name3").age(45).mail("name3gmail.com").build());
        given(affiliatesService.consultarAffiliates()).willReturn(listaAffiliates);

        //when
        ResultActions response = mockMvc.perform(get("/affiliates/consultarAffiliates"));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",is(listaAffiliates.size())));
	}

	@Test
	void testConsultarByIdAffiliate() throws Exception {
		//given
        long id = 1L;
        Affiliate affiliate = Affiliate.builder()
                .name("name1")
                .age(25)
                .mail("name1@gmail.com")
                .build();
        given(affiliatesService.consultarByIdAffiliate(id)).willReturn(affiliate);

        //when
        ResultActions response = mockMvc.perform(get("/affiliates/consultarByIdAffiliate/{id}",id));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name",is(affiliate.getName())))
                .andExpect(jsonPath("$.age",is(affiliate.getAge())))
                .andExpect(jsonPath("$.mail",is(affiliate.getMail())));
	}

	@Test
	void testGuardarAffiliate() throws Exception {
		//given
		
		Affiliate affiliate = Affiliate.builder()
				.name("name1")
                .age(25)
                .mail("name1@gmail.com")
                .build();
		given(affiliatesService.guardarAffiliate(any(Affiliate.class))).willAnswer((invocation)->invocation.getArgument(0));
		
		//when
		
		ResultActions response = mockMvc.perform(post("/affiliates/guardarAffiliate")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(affiliate)));
		
		//then
		response.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name",is(affiliate.getName())))
                .andExpect(jsonPath("$.age",is(affiliate.getAge())))
                .andExpect(jsonPath("$.mail",is(affiliate.getMail())));
	}

	@Test
	void testActualizarAffiliate() throws Exception {
		
		//given
        long id = 1L;
        Affiliate affiliateGuardado = Affiliate.builder()
        		.name("name1")
                .age(25)
                .mail("name1@gmail.com")
                .build();

        Affiliate affiliateActualizado = Affiliate.builder()
        		.name("name1")
                .age(25)
                .mail("name1@gmail.com")
                .build();

        given(affiliatesService.consultarByIdAffiliate(id)).willReturn(affiliateGuardado);
        given(affiliatesService.actualizarAffiliate(any(Affiliate.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(put("/affiliates/actualizarAffiliate/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(affiliateActualizado)));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name",is(affiliateActualizado.getName())))
                .andExpect(jsonPath("$.age",is(affiliateActualizado.getAge())))
                .andExpect(jsonPath("$.mail",is(affiliateActualizado.getMail())));
	}

	@Test
	void testEliminarAffiliate() throws Exception {
		//given
        long id = 1L;
        willDoNothing().given(affiliatesService).eliminarAffiliate(id);

        //when
        ResultActions response = mockMvc.perform(delete("/affiliates/eliminarAffiliate/{id}",id));

        //then
        response.andExpect(status().isOk())
                .andDo(print());
	}

}
