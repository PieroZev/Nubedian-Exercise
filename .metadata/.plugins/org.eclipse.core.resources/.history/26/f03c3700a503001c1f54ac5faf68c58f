package Nerubian.Exercise.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import Nerubian.Exercise.mapper.SocketMapper;
import Nerubian.Exercise.model.Socket;
import Nerubian.Exercise.repository.SocketRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SocketServiceTest {
	
	//List of test sockets
    private final List<Socket> SocketsDePrueba = new ArrayList<>();
    
    // Socket to Add
    private final Socket SocketParaAgregar = new Socket();

    @InjectMocks
    SocketServiceImpl SocketService;

    @Mock
    SocketRepository socketRepository;

    @Spy
    SocketMapper mapper = SocketMapper.INSTANCE;

    @BeforeEach
    public void setUp() {

        SocketsDePrueba.clear();
        SocketsDePrueba.add(new Socket());
        SocketsDePrueba.add(new Socket());
        SocketsDePrueba.add(new Socket());
        SocketsDePrueba.add(new Socket());
        SocketsDePrueba.get(0).setDescription("Socket 1");
        SocketsDePrueba.get(1).setDescription("Socket 2");
        SocketsDePrueba.get(2).setDescription("Socket 3");
        SocketsDePrueba.get(3).setDescription("Socket 4");
        SocketsDePrueba.get(0).setSocketId(1L);
        SocketsDePrueba.get(1).setSocketId(2L);
        SocketsDePrueba.get(2).setSocketId(3L);
        SocketsDePrueba.get(3).setSocketId(4L);

        SocketParaAgregar.setSocketId(5L);
        SocketParaAgregar.setDescription("Socket 5");
        

    }

    @Test
    void testListSockets() {
        when(socketRepository.findAll()).thenReturn(SocketsDePrueba);
        List<Socket> SocketsConseguidos = SocketService.listAll();
        assertEquals(SocketsDePrueba.size(),SocketsConseguidos.size());
    }

    @Test
    void testGetSocketByID() {
        when(socketRepository.findById(SocketsDePrueba.get(0).getSocketId())).thenReturn(Optional.of(SocketsDePrueba.get(0)));
        Socket SocketEncontrado = SocketService.getById(SocketsDePrueba.get(0).getSocketId());
        assertEquals(SocketsDePrueba.get(0).getSocketId(),SocketEncontrado.getSocketId());
    }

    @Test
    void testSaveOrUpdate() {
        SocketService.save(SocketParaAgregar);

        ArgumentCaptor<Socket> argumentCaptor = ArgumentCaptor.forClass(Socket.class);
        verify(socketRepository).save(argumentCaptor.capture());
        assertEquals(SocketParaAgregar.getSocketId(),argumentCaptor.getValue().getSocketId());
    }

    @Test
    void testDelete() {
        Long idParaBorrar = 1L;
        when(socketRepository.existsById(1L)).thenReturn(true);

        SocketService.delete(idParaBorrar);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(socketRepository).deleteById(argumentCaptor.capture());
        assertEquals(idParaBorrar,argumentCaptor.getValue());
    }

    @Test
    void testDeleteNotFound() {
        Long idParaBorrar = 1L;
        when(socketRepository.existsById(1L)).thenReturn(false);
        assertThrows(NoSuchElementException.class, () -> SocketService.delete(idParaBorrar));
    }

    @Test
    void testInsertExisting() {
        when(socketRepository.existsById(SocketParaAgregar.getSocketId())).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () ->  SocketService.save(SocketParaAgregar));
    }

    @Test
    void testUpdateExisting() {
        when(socketRepository.existsById(SocketParaAgregar.getSocketId())).thenReturn(true);
        SocketService.update(SocketParaAgregar);
        ArgumentCaptor<Socket> argumentCaptor = ArgumentCaptor.forClass(Socket.class);
        verify(socketRepository).save(argumentCaptor.capture());
        assertEquals(SocketParaAgregar.getSocketId(),argumentCaptor.getValue().getSocketId());
    }

    @Test
    void testUpdateNotFound() {
        when(socketRepository.existsById(SocketParaAgregar.getSocketId())).thenReturn(false);
        assertThrows(NoSuchElementException.class, () ->  SocketService.update(SocketParaAgregar));
    }
}