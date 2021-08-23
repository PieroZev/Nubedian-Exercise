package Nerubian.Exercise.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import Nerubian.Exercise.mapper.CPUMapper;
import Nerubian.Exercise.model.CPU;
import Nerubian.Exercise.repository.CPURepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CPUServiceTest {
	
	//List of test CPUs
	private final List<CPU> CPUsDePrueba = new ArrayList<>();

	//CPUtoAdd
	private final CPU CPUParaAgregar = new CPU();

	@InjectMocks
	CPUServiceImpl cpuService;

	@Mock
	CPURepository cpuRepository;

	@Spy
	CPUMapper mapper = CPUMapper.INSTANCE;

	@BeforeEach
	public void setUp() {

		CPUsDePrueba.clear();
		CPUsDePrueba.add(new CPU());
		CPUsDePrueba.add(new CPU());
		CPUsDePrueba.add(new CPU());
		CPUsDePrueba.add(new CPU());

		CPUsDePrueba.get(0).setModel("CPU 1");
		CPUsDePrueba.get(1).setModel("CPU 2");
		CPUsDePrueba.get(2).setModel("CPU 3");
		CPUsDePrueba.get(3).setModel("CPU 4");
		CPUsDePrueba.get(0).setId(1L);
		CPUsDePrueba.get(1).setId(2L);
		CPUsDePrueba.get(2).setId(3L);
		CPUsDePrueba.get(3).setId(4L);
		CPUsDePrueba.get(0).setBrand("Brand 1");
		CPUsDePrueba.get(1).setBrand("Brand 2");
		CPUsDePrueba.get(2).setBrand("Brand 3");
		CPUsDePrueba.get(3).setBrand("brand 4");

		CPUParaAgregar.setId(5L);
		CPUParaAgregar.setModel("CPU 5");
		CPUParaAgregar.setBrand("Brand 5");
	}

	@Test
	void testListCPUs() {
		when(cpuRepository.findAll()).thenReturn(CPUsDePrueba);

		List<CPU> CPUsConseguidos = cpuService.listAll();
		assertEquals(CPUsDePrueba.toString(), CPUsConseguidos.toString());
	}

	@Test
	void testGetCPUByID() {
		when(cpuRepository.findById(CPUsDePrueba.get(0).getId()))
				.thenReturn(Optional.of(CPUsDePrueba.get(0)));
		CPU CPUEncontrado = cpuService.getById(CPUsDePrueba.get(0).getId());
		assertEquals(CPUsDePrueba.get(0).getId(), CPUEncontrado.getId());
		assertEquals(CPUsDePrueba.get(0).getBrand(), CPUEncontrado.getBrand());
		assertEquals(CPUsDePrueba.get(0).getModel(), CPUEncontrado.getModel());
	}

	@Test
	void testSaveOrUpdate() {
		cpuService.save(CPUParaAgregar);
		ArgumentCaptor<CPU> argumentCaptor = ArgumentCaptor.forClass(CPU.class);
		verify(cpuRepository).save(argumentCaptor.capture());
		assertEquals(CPUParaAgregar.getId(),argumentCaptor.getValue().getId());
		assertEquals(CPUParaAgregar.getBrand(),argumentCaptor.getValue().getBrand());
		assertEquals(CPUParaAgregar.getModel(),argumentCaptor.getValue().getModel());
	}

	@Test
	void testDelete() {
		Long idtoDelete = 1L;
		when(cpuRepository.existsById(1L)).thenReturn(true);
		cpuService.delete(idtoDelete);
		ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
		verify(cpuRepository).deleteById(argumentCaptor.capture());
		assertEquals(idtoDelete, argumentCaptor.getValue());
	}

	@Test
	void testDeleteNotFound() {
		Long idtoDelete = 1L;
		when(cpuRepository.existsById(1L)).thenReturn(false);
		assertThrows(NoSuchElementException.class, () -> cpuService.delete(idtoDelete));
	}
	@Test
	void testInsertExisting() {
		when(cpuRepository.existsById(CPUParaAgregar.getId())).thenReturn(true);
		assertThrows(IllegalArgumentException.class, () ->  cpuService.save(CPUParaAgregar));
	}
	@Test
	void testUpdateExisting() {
		when(cpuRepository.existsById(CPUParaAgregar.getId())).thenReturn(true);
		cpuService.update(CPUParaAgregar);
		ArgumentCaptor<CPU> argumentCaptor = ArgumentCaptor.forClass(CPU.class);
		verify(cpuRepository).save(argumentCaptor.capture());
		assertEquals(CPUParaAgregar.getId(),argumentCaptor.getValue().getId());
		assertEquals(CPUParaAgregar.getBrand(),argumentCaptor.getValue().getBrand());
		assertEquals(CPUParaAgregar.getModel(),argumentCaptor.getValue().getModel());
	}
	@Test
	void testUpdateNotFound() {
		when(cpuRepository.existsById(CPUParaAgregar.getId())).thenReturn(false);
		assertThrows(NoSuchElementException.class, () ->  cpuService.update(CPUParaAgregar));
	}
}