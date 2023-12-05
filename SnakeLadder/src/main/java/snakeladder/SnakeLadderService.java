package snakeladder;

import com.pro.grpc.models.Role;
import com.pro.grpc.models.ServerResponse;
import com.pro.grpc.models.SnakeLadderServiceGrpc;
import io.grpc.stub.StreamObserver;

public class SnakeLadderService extends SnakeLadderServiceGrpc.SnakeLadderServiceImplBase {
    @Override
    public StreamObserver<Role> play(StreamObserver<ServerResponse> responseObserver) {
        return new PlayObserver(responseObserver);
    }


}
