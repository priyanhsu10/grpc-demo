import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.BankService;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(5656)
            .addService(new BankService())
            .build();
    server.start();
    System.out.println("server started at port 5656...");
    server.awaitTermination();
}

}
