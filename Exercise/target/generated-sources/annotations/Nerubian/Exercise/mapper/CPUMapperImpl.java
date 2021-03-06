package Nerubian.Exercise.mapper;

import Nerubian.Exercise.model.CPU;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-22T16:44:37-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190903-0936, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class CPUMapperImpl implements CPUMapper {

    @Override
    public CPU toCPU(CPU cpu) {
        if ( cpu == null ) {
            return null;
        }

        CPU cPU = new CPU();

        cPU.setBrand( cpu.getBrand() );
        cPU.setClockSpeed( cpu.getClockSpeed() );
        cPU.setId( cpu.getId() );
        cPU.setModel( cpu.getModel() );
        cPU.setNumberOfCores( cpu.getNumberOfCores() );
        cPU.setNumberOfThreads( cpu.getNumberOfThreads() );
        cPU.setPrice( cpu.getPrice() );
        cPU.setTdp( cpu.getTdp() );

        return cPU;
    }
}
