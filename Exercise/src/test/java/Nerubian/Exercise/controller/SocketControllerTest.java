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

import Nerubian.Exercise.model.Socket;
import Nerubian.Exercise.service.SocketServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(SocketController.class)
class SocketControllerTest {
    String basePath = "/nerubian/api/sockets/";

    List<Socket> socketsDePrueba = new ArrayList<>();
    JSONArray socketsDePruebaEnJSON = new JSONArray();
    Socket SocketParaAgregar = new Socket();

    @Autowired
    MockMvc mockMvc;

    @Autowired
    SocketController socketController;

    @MockBean
    SocketServiceImpl socketService;

    @BeforeEach
    public void setUp() {
        socketsDePrueba.add(new Socket());
        socketsDePrueba.add(new Socket());
        socketsDePrueba.add(new Socket());
        socketsDePrueba.add(new Socket());
        socketsDePrueba.get(0).setDescription("mouse");
        socketsDePrueba.get(1).setDescription("keyboard");
        socketsDePrueba.get(2).setDescription("usb");
        socketsDePrueba.get(3).setDescription("battery");
        socketsDePrueba.get(0).setSocketId(1L);
        socketsDePrueba.get(1).setSocketId(2L);
        socketsDePrueba.get(2).setSocketId(3L);
        socketsDePrueba.get(3).setSocketId(4L);
        

        SocketParaAgregar.setSocketId(5L);
        SocketParaAgregar.setDescription("hdmi");
        

        socketsDePrueba.forEach((x) -> socketsDePruebaEnJSON.put(x.toJSONObject()));

    }

    @Test
    void testListAll() throws Exception {
        when(socketService.listAll()).thenReturn(socketsDePrueba);

        mockMvc.perform(MockMvcRequestBuilders.get(basePath).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(socketsDePruebaEnJSON.toString()));
    }

    @Test
    void testGetByID() throws Exception {
        long idSocketGet = 1L;
        when(socketService.getById(1L)).thenReturn(socketsDePrueba.get(0));

        mockMvc.perform(MockMvcRequestBuilders.get(basePath + idSocketGet).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(socketsDePrueba.get(0)
                        .toJSONObject().toString()));
    }

    @Test
    void testSaveSocket() throws Exception {
        when(socketService.save(any())).thenReturn(new Socket());

        mockMvc.perform(MockMvcRequestBuilders.post(basePath).contentType(MediaType.APPLICATION_JSON)
                .content(SocketParaAgregar.toJSONObject().toString()))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        ArgumentCaptor<Socket> argumentCaptor = ArgumentCaptor.forClass(Socket.class);
        verify(socketService).save(argumentCaptor.capture());
        assertEquals(SocketParaAgregar.getDescription(),argumentCaptor.getValue().getDescription());
    }


    @Test
    void testUpdateSocket() throws Exception {
        when(socketService.update(any())).thenReturn(new Socket());

        mockMvc.perform(MockMvcRequestBuilders.put(basePath + socketsDePrueba.get(0).getSocketId()).contentType(MediaType.APPLICATION_JSON)
                .content(SocketParaAgregar.toJSONObject().toString()))
                .andExpect(MockMvcResultMatchers.status().isOk());

        ArgumentCaptor<Socket> argumentCaptor = ArgumentCaptor.forClass(Socket.class);
        verify(socketService).update(argumentCaptor.capture());
        assertEquals(socketsDePrueba.get(0).getSocketId(),argumentCaptor.getValue().getSocketId());
        assertEquals(SocketParaAgregar.getDescription(),argumentCaptor.getValue().getDescription());
    }

    @Test
    void testDeleteSocket() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(basePath + socketsDePrueba.get(0).getSocketId()))
                .andExpect(MockMvcResultMatchers.status().isOk());

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(socketService).delete(argumentCaptor.capture());
        assertEquals(socketsDePrueba.get(0).getSocketId(),argumentCaptor.getValue());
    }

}
