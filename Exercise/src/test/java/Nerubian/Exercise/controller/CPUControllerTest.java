package Nerubian.Exercise.controller;

import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import Nerubian.Exercise.model.CPU;
import Nerubian.Exercise.service.CPUServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(CPUController.class)
class CPUControllerTest {
	String basePath = "/nerubian/api/cpus/";
	List<CPU> CPUsDePrueba = new ArrayList<>();
	JSONArray CPUsDePruebaEnJSON = new JSONArray();
	CPU CPUParaAgregar = new CPU();

	@Autowired
	MockMvc mockMvc;

	@Autowired
	CPUController CPUController;

	@MockBean
	CPUServiceImpl CPUService;

	@BeforeEach
	public void setUp() {
		CPUsDePrueba.clear();
		CPUsDePrueba.add(new CPU());
		CPUsDePrueba.add(new CPU());
		CPUsDePrueba.add(new CPU());
		CPUsDePrueba.add(new CPU());

		
		CPUsDePrueba.get(0).setBrand("Brand 1");
		CPUsDePrueba.get(1).setBrand("Brand 2");
		CPUsDePrueba.get(2).setBrand("Brand 3");
		CPUsDePrueba.get(3).setBrand("Brand 4");
		CPUsDePrueba.get(0).setModel("CPU 1");
		CPUsDePrueba.get(1).setModel("CPU 2");
		CPUsDePrueba.get(2).setModel("CPU 3");
		CPUsDePrueba.get(3).setModel("CPU 4");
		CPUsDePrueba.get(0).setId(1L);
		CPUsDePrueba.get(1).setId(2L);
		CPUsDePrueba.get(2).setId(3L);
		CPUsDePrueba.get(3).setId(4L);

		CPUParaAgregar.setId(5L);
		CPUParaAgregar.setBrand("Brand 5");
		CPUParaAgregar.setModel("CPU 5");

		CPUsDePrueba.forEach((x) -> CPUsDePruebaEnJSON.put(x.toJSONObject()));

	}

	@Test
	void testListAll() throws Exception {
		when(CPUService.listAll()).thenReturn(CPUsDePrueba);

		mockMvc.perform(MockMvcRequestBuilders.get(basePath).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(CPUsDePruebaEnJSON.toString()));
	}

	@Test
	void testGetByID() throws Exception {
		long idCPUGet = 1L;
		when(CPUService.getById(1L)).thenReturn(CPUsDePrueba.get(0));

		mockMvc.perform(MockMvcRequestBuilders.get(basePath + idCPUGet).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(CPUsDePrueba.get(0)
						.toJSONObject().toString()));
	}

	@Test
	void testSaveCPU() throws Exception {
		when(CPUService.save(any())).thenReturn(new CPU());

		mockMvc.perform(MockMvcRequestBuilders.post(basePath).contentType(MediaType.APPLICATION_JSON)
				.content(CPUParaAgregar.toString()))
				.andExpect(MockMvcResultMatchers.status().isCreated());

		ArgumentCaptor<CPU> argumentCaptor = ArgumentCaptor.forClass(CPU.class);
		verify(CPUService).save(argumentCaptor.capture());
		assertEquals(CPUParaAgregar.getModel(), argumentCaptor.getValue().getModel());
	}


	@Test
	void testUpdateCPU() throws Exception {
		when(CPUService.update(any())).thenReturn(new CPU());

		mockMvc.perform(MockMvcRequestBuilders.put(basePath+ CPUsDePrueba.get(0).getId()).contentType(MediaType.APPLICATION_JSON)
				.content(CPUParaAgregar.toJSONObject().toString()))
				.andExpect(MockMvcResultMatchers.status().isOk());

		ArgumentCaptor<CPU> argumentCaptor = ArgumentCaptor.forClass(CPU.class);
		verify(CPUService).update(argumentCaptor.capture());
		assertEquals(CPUsDePrueba.get(0).getId(), argumentCaptor.getValue().getId());
		assertEquals(CPUParaAgregar.getModel(), argumentCaptor.getValue().getModel());
	}

	@Test
	void testDeleteCPU() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete(basePath+ CPUsDePrueba.get(0).getId()))
				.andExpect(MockMvcResultMatchers.status().isOk());

		ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
		verify(CPUService).delete(argumentCaptor.capture());
		assertEquals(CPUsDePrueba.get(0).getId(), argumentCaptor.getValue());
	}
}
