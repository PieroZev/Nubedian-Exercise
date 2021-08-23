package Nerubian.Exercise.service;

import java.util.List;
import java.util.NoSuchElementException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Nerubian.Exercise.mapper.CPUMapper;
import Nerubian.Exercise.model.CPU;
import Nerubian.Exercise.repository.CPURepository;

@Service
public class CPUServiceImpl implements CPUService {

	private final CPURepository cpurepository;
	private final CPUMapper cpuMapper;
	

	CPU cpu1 = new CPU("Lenovo", "Ideapad", 3.5, 8, 10, 6.3, 1000.00);
	CPU cpu2 = new CPU("Lenovo", "TinkPad", 3.5, 8, 10, 6.3, 1000.00);
	CPU cpu3 = new CPU("Lenovo", "Yoga", 3.5, 8, 10, 6.3, 1000.00);
	CPU cpu4 = new CPU("HP", "All in One", 3.5, 8, 10, 6.3, 1000.00);
	CPU cpu5 = new CPU("Enkore", "Core i7", 3.5, 8, 10, 6.3, 1000.00);
	
	public void setCPUs() {
		cpurepository.save(cpu1);
		cpurepository.save(cpu2);
		cpurepository.save(cpu3);
		cpurepository.save(cpu4);
		cpurepository.save(cpu5);
	}
	
	public CPUServiceImpl(CPURepository cpurepository, CPUMapper cpuMapper) {
		this.cpurepository = cpurepository;
		this.cpuMapper = cpuMapper;
	};
	
	public List<CPU> listAll() {
		if(cpurepository.findAll().isEmpty())
		setCPUs();
		return cpurepository.findAll();
	}

	public CPU getById(Long id) {
		// TODO Auto-generated method stub
		return cpurepository.findById(id).map(this.cpuMapper::toCPU)
                .orElseThrow(() -> new NoSuchElementException());
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		cpurepository.deleteById(id);
	}

	public CPU save(CPU cpu) {
		// TODO Auto-generated method stub
		return cpurepository.save(cpu);
	}

	public CPU update(CPU cpu) {
		if(cpurepository.findById(cpu.getId())!=null){
			return cpurepository.save(cpu);
		}
		else return null;
	}

	
	
}
