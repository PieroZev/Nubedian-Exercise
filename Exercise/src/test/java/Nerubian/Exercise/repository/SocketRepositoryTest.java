package Nerubian.Exercise.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import Nerubian.Exercise.model.Socket;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class SocketRepositoryTest {

    private static final Socket socket1 = new Socket();
    private static final Socket socket2 = new Socket();
    private static final Socket socket3 = new Socket();

    @Autowired
    private SocketRepository repository;

    @Test
    public void findAllByOrderByNombreAsc() {
        List<Socket> socketsExpected = new ArrayList<>();
        socketsExpected.add(socket2);
        socketsExpected.add(socket3);
        socketsExpected.add(socket1);

        repository.save(socket1);
        repository.save(socket2);
        repository.save(socket3);

        List<Socket> sockets = repository.findAll();
        assertNotNull(sockets);
        assertEquals(socketsExpected,sockets);
    }

}
