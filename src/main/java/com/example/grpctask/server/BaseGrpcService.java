package com.example.grpctask.server;

import com.example.grpctask.proto.CreateLogRequest;
import com.example.grpctask.proto.LogServiceGrpc;
import com.example.grpctask.service.BaseService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.lognet.springboot.grpc.GRpcService;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@GRpcService
public class BaseGrpcService extends LogServiceGrpc.LogServiceImplBase {
    BaseService baseService;

    @Override
    public void createLog(CreateLogRequest request, StreamObserver<Empty> responseObserver) {
        try {
            baseService.createLog(request);
            responseObserver.onNext(Empty.getDefaultInstance());
        } finally {
            responseObserver.onCompleted();
        }
    }
}
