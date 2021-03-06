package Nerubian.Exercise.mapper;

import Nerubian.Exercise.model.Socket;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-22T18:05:18-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190903-0936, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class SocketMapperImpl implements SocketMapper {

    @Override
    public Socket toSocket(Socket socket) {
        if ( socket == null ) {
            return null;
        }

        Socket socket1 = new Socket();

        socket1.setCpu( socket.getCpu() );
        socket1.setDescription( socket.getDescription() );
        socket1.setSocketId( socket.getSocketId() );

        return socket1;
    }
}
