package com.eccco.floki.api.grpc;

import an.awesome.pipelinr.Pipeline;
import com.eccco.floki.clients.application.create.CreateClientCommand;
import com.eccco.floki.clients.application.dtos.CreateClientDto;
import com.test.grpc.hello.HelloRequest;
import com.test.grpc.hello.HelloResponse;
import com.test.grpc.hello.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.text.MessageFormat;

@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    private final Pipeline pipeline;

    public HelloService(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        CreateClientDto payload = CreateClientDto.builder().name(request.getFirstName()).age(30).build();
        var command = new CreateClientCommand(payload);
        var response = pipeline.send(command);

        HelloResponse reply = HelloResponse.newBuilder()
                .setGreeting(MessageFormat.format("Hello {0} : {1} {2}", response.getClientId(), request.getFirstName(), request.getLastName()))
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
