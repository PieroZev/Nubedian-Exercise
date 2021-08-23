package Nerubian.Exercise.service;

import java.util.List;

import Nerubian.Exercise.model.CPU;

public interface CPUService {

	List<CPU> listAll();

	CPU getById(Long id);
	
	void delete(Long id);

	CPU save(CPU cpu);

	CPU update(CPU cpu);
	
}
