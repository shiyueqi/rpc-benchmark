package com.shiyueqi.rpc.benchmark.grpc.server;

import com.shiyueqi.rpc.benchmark.grpc.common.Users;
import com.shiyueqi.rpc.benchmark.grpc.user.*;
import com.unionpay.rpc.benchmark.grpc.user.*;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.logging.Logger;

/**
 * date: 2016/10/19 10:21.
 * author: Yueqi Shi
 */
public class GrpcServer {
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    /* The port on which the server should run */
    private int port = 50071;
    private Server server;

    private void start() throws Exception {
        server = NettyServerBuilder.forPort(port)
                .channelType(NioServerSocketChannel.class)
                .bossEventLoopGroup(new NioEventLoopGroup(10))
                .workerEventLoopGroup(new NioEventLoopGroup(200))
                .addService(new UserServiceImpl())
                .build().start();

        logger.info("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                GrpcServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws Exception {
        final GrpcServer server = new GrpcServer();
        server.start();
    }

    private class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
        private User user = Users.getUser(0l);

        private UserReply userReply = UserReply.newBuilder()
                .setUser(user)
                .build();

        private String userName = Users.getUserName(0l);

        private UserReplyStr userReplyStr = UserReplyStr.newBuilder()
                .setUserName(userName)
                .build();

        @Override
        public void getUser(UserRequest request, StreamObserver<UserReply> responseObserver) {

            responseObserver.onNext(userReply);
            responseObserver.onCompleted();
        }

        @Override
        public void getUserName(UserRequest request, StreamObserver<UserReplyStr> responseObserver) {
            responseObserver.onNext(userReplyStr);
            responseObserver.onCompleted();
        }
    }
}
