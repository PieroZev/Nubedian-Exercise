package Nerubian.Exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Nerubian.Exercise.model.Socket;

public interface SocketRepository extends JpaRepository<Socket, Long>{

	Socket findByCpuId(Long id);
}
