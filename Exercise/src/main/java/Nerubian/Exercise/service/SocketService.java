package Nerubian.Exercise.service;

import java.util.List;

import Nerubian.Exercise.model.Socket;

public interface SocketService {

	List<Socket> listAll();

	Socket getByCPUId(Long id);
	
	Socket getById(Long id);
	
	void delete(Long id);

	Socket save(Socket socket);

	Socket update(Socket socket);
	
}
