import io.grpc.Server;
import io.grpc.ServerBuilder;
import snakeladder.SnakeLadderService;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server= ServerBuilder.forPort(5656)
                .addService(new SnakeLadderService())
                .build();
        server.start();
        System.out.println("server started ad port 5656");
        server.awaitTermination();
    }
}
