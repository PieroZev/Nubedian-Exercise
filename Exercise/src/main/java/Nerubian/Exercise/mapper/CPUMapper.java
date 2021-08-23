package Nerubian.Exercise.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.InjectionStrategy;

import Nerubian.Exercise.model.CPU;

@Mapper(uses = {SocketMapper.class},componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CPUMapper {

	CPUMapper INSTANCE = Mappers.getMapper(CPUMapper.class);
	
	CPU toCPU(CPU cpu);
}
