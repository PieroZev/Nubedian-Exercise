package Nerubian.Exercise.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import Nerubian.Exercise.mapper.SocketMapper;
import Nerubian.Exercise.model.Socket;
import Nerubian.Exercise.repository.SocketRepository;

@Service
public class SocketServiceImpl implements SocketService{

private final SocketRepository socketRepository;
private final SocketMapper socketMapper;

Socket socket1 = new Socket(1L,"Keyboard", 1L);
Socket socket2 = new Socket(2L,"Mouse", 2L);
Socket socket3 = new Socket(3L,"USB plug", 3L);
Socket socket4 = new Socket(4L,"HDMI", 4L);
Socket socket5 = new Socket(5L,"Battery", 5L);

public void setSockets() {
	socketRepository.save(socket1);
	socketRepository.save(socket2);
	socketRepository.save(socket3);
	socketRepository.save(socket4);
	socketRepository.save(socket5);
}
	
	public SocketServiceImpl(SocketRepository socketRepository, SocketMapper socketMapper) {
		this.socketRepository = socketRepository;
		this.socketMapper = socketMapper;
	};
	
	
	public List<Socket> listAll() {
		// TODO Auto-generated method stub
		if(socketRepository.findAll().isEmpty()) {
			setSockets();
		}
		return socketRepository.findAll();
	}

	public Socket getByCPUId(Long id) {
		// TODO Auto-generated method stub
		return socketRepository.findByCpuId(id);
	}
	
	public Socket getById(Long id) {
		// TODO Auto-generated method stub
		return socketRepository.findById(id).map(this.socketMapper::toSocket)
                .orElseThrow(() -> new NoSuchElementException());
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		socketRepository.deleteById(id);
	}

	public Socket save(Socket socket) {
		// TODO Auto-generated method stub
		return socketRepository.save(socket);
	}

	public Socket update(Socket socket) {
		// TODO Auto-generated method stub
		if(socketRepository.findById(socket.getSocketId())!=null){
			return socketRepository.save(socket);
		}
		else return null;
	}

}
