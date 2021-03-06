package Nerubian.Exercise.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import Nerubian.Exercise.model.CPU;

@DataJpaTest
public class CPURepositoryTest {

	private static final CPU CPU1 = new CPU();
	
	@Autowired
    private CPURepository repository;

    @Test
    public void findAll() {
        List<CPU> cpusExpected = new ArrayList<>();
        cpusExpected.add(CPU1);
        

        repository.save(CPU1);

        List<CPU> cpus = repository.findAll();
        assertNotNull(cpus);
        assertEquals(cpusExpected,cpus);
    }
}
