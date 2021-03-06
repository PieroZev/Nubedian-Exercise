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

import Nerubian.Exercise.model.Socket;
import Nerubian.Exercise.service.SocketService;

@RestController
@CrossOrigin
@RequestMapping("nerubian/api/sockets")
public class SocketController {

private final SocketService socketService;
	
	public SocketController(SocketService socketService) {
		this.socketService = socketService;
	};
	
	@GetMapping("")
    public ResponseEntity<List<Socket>> listAll() {
        return ResponseEntity.ok(socketService.listAll());
    }

    @GetMapping("/cpu/{id}")
    public ResponseEntity<Socket> getByCPUId(@PathVariable Long id) {
        Socket socket = socketService.getByCPUId(id);
        return ResponseEntity.ok(socket);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Socket> getById(@PathVariable Long id) {
        Socket socket = socketService.getById(id);
        return ResponseEntity.ok(socket);
    }

    @PostMapping(value = "")
    public ResponseEntity<Long> saveSocket(@RequestBody Socket socket) {
         socket = socketService.save(socket);
        return new ResponseEntity<>(
                socket.getSocketId(),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> updateSocket(@PathVariable Long id, @RequestBody Socket socket) {
        socket.setSocketId(id);
        Socket updatedsocket = socketService.update(socket);
        return ResponseEntity.ok(updatedsocket.getSocketId());
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSocket(@PathVariable Long id) {
        ResponseEntity<Void> response;
        socketService.delete(id);
        response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }
}
