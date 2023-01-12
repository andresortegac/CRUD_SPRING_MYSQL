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

@WebMvcTest
class TestsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TestsService testsService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testConsultarTests() throws Exception {
		
		//given
        List<TestEntity> listaTests = new ArrayList<>();
        listaTests.add(TestEntity.builder().name("name1").description("desc1").build());
        listaTests.add(TestEntity.builder().name("name2").description("desc2").build());
        listaTests.add(TestEntity.builder().name("name3").description("desc3").build());
        listaTests.add(TestEntity.builder().name("name4").description("desc4").build());
        listaTests.add(TestEntity.builder().name("name5").description("desc5").build());
        given(testsService.consultarTests()).willReturn(listaTests);

        //when
        ResultActions response = mockMvc.perform(get("/tests/consultarTests"));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",is(listaTests.size())));
		
	}

	@Test
	void testConsultarByIdTest() throws Exception{
		
		//given
        long id = 1L;
        TestEntity test = TestEntity.builder()
                .name("name1")
                .description("desc1")
                .build();
        given(testsService.consultarByIdTest(id)).willReturn(test);

        //when
        ResultActions response = mockMvc.perform(get("/tests/consultarByIdTest/{id}",id));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.nombre",is(test.getName())))
                .andExpect(jsonPath("$.apellido",is(test.getDescription())));
	}

	@Test
	void testGuardarTest() throws Exception {
		
		//given
		
		TestEntity testEntity = TestEntity.builder()
				.id(1L)
				.name("namePrueba")
				.description("desciptionPrueba")
				.build();
		given(testsService.guardarTest(any(TestEntity.class))).willAnswer((invocation)->invocation.getArgument(0));
		
		//when
		
		ResultActions response = mockMvc.perform(post("/tests/guardarTest")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(testEntity)));
		
		//then
		response.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name", is(testEntity.getName())))
				.andExpect(jsonPath("$.description", is(testEntity.getDescription())));
	}

	@Test
	void testActualizarTest() throws Exception{
		//given
        long id = 1L;
        TestEntity testGuardado = TestEntity.builder()
        		.name("namePrueba")
				.description("desciptionPrueba")
				.build();

        TestEntity testActualizado = TestEntity.builder()
        		.name("namePrueba")
				.description("desciptionPrueba")
				.build();

        given(testsService.consultarByIdTest(id)).willReturn(testGuardado);
        given(testsService.actualizarTest(any(TestEntity.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(put("/tests/actualizarTest/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testActualizado)));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name",is(testActualizado.getName())))
                .andExpect(jsonPath("$.description",is(testActualizado.getDescription())));
	}

	@Test
	void testEliminarTest() throws Exception{
		//given
        long id = 1L;
        willDoNothing().given(testsService).eliminarTest(id);

        //when
        ResultActions response = mockMvc.perform(delete("/tests/eliminarTest/{id}",id));

        //then
        response.andExpect(status().isOk())
                .andDo(print());
	}

}
