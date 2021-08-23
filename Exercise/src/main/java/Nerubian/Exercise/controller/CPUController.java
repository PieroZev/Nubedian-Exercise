package Nerubian.Exercise.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Nerubian.Exercise.model.CPU;
import Nerubian.Exercise.service.CPUService;

@RestController
@CrossOrigin
@RequestMapping("nerubian/api/cpus")
public class CPUController {

private final CPUService cpuService;
	
	public CPUController(CPUService cpuService) {
		this.cpuService = cpuService;
	};
	
	@GetMapping("")
    public ResponseEntity<List<CPU>> listAll() {
        return ResponseEntity.ok(cpuService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CPU> getById(@PathVariable Long id) {
        CPU cpu = cpuService.getById(id);
        return ResponseEntity.ok(cpu);
    }

    @PostMapping(value = "")
    public ResponseEntity<Long> saveCPU(@RequestBody CPU cpu) {
         cpu = cpuService.save(cpu);
        return new ResponseEntity<>(
                cpu.getId(),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> updateCPU(@PathVariable Long id, @RequestBody CPU cpu) {
        cpu.setId(id);
        CPU updatedCPU = cpuService.update(cpu);
        return ResponseEntity.ok(updatedCPU.getId());
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCPU(@PathVariable Long id) {
        ResponseEntity<Void> response;
        cpuService.delete(id);
        response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }
}
