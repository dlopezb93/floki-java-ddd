package com.eccco.floki.api.grpc;

import com.test.grpc.location.LocationRequest;
import com.test.grpc.location.LocationResponse;
import com.test.grpc.location.LocationServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class LocationService extends LocationServiceGrpc.LocationServiceImplBase {

    @Override
    public void save(LocationRequest request, StreamObserver<LocationResponse> responseObserver) {
        LocationResponse response = LocationResponse.newBuilder().setSaved(true).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
