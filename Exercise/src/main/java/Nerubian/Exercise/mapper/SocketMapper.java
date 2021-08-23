package Nerubian.Exercise.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import Nerubian.Exercise.model.Socket;

@Mapper(componentModel = "spring")
public interface SocketMapper {

	SocketMapper INSTANCE = Mappers.getMapper(SocketMapper.class);
	
	Socket toSocket(Socket socket);
}
