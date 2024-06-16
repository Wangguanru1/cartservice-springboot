package edu.whu.cartstore.cart;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.64.0)",
    comments = "Source: Cart.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CartServiceGrpc {

  private CartServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "hipstershop.CartService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CartOuterClass.AddItemRequest,
      CartOuterClass.Empty> getAddItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddItem",
      requestType = CartOuterClass.AddItemRequest.class,
      responseType = CartOuterClass.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CartOuterClass.AddItemRequest,
      CartOuterClass.Empty> getAddItemMethod() {
    io.grpc.MethodDescriptor<CartOuterClass.AddItemRequest, CartOuterClass.Empty> getAddItemMethod;
    if ((getAddItemMethod = CartServiceGrpc.getAddItemMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getAddItemMethod = CartServiceGrpc.getAddItemMethod) == null) {
          CartServiceGrpc.getAddItemMethod = getAddItemMethod =
              io.grpc.MethodDescriptor.<CartOuterClass.AddItemRequest, CartOuterClass.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddItem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CartOuterClass.AddItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CartOuterClass.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("AddItem"))
              .build();
        }
      }
    }
    return getAddItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CartOuterClass.GetCartRequest,
      CartOuterClass.Cart> getGetCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCart",
      requestType = CartOuterClass.GetCartRequest.class,
      responseType = CartOuterClass.Cart.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CartOuterClass.GetCartRequest,
      CartOuterClass.Cart> getGetCartMethod() {
    io.grpc.MethodDescriptor<CartOuterClass.GetCartRequest, CartOuterClass.Cart> getGetCartMethod;
    if ((getGetCartMethod = CartServiceGrpc.getGetCartMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getGetCartMethod = CartServiceGrpc.getGetCartMethod) == null) {
          CartServiceGrpc.getGetCartMethod = getGetCartMethod =
              io.grpc.MethodDescriptor.<CartOuterClass.GetCartRequest, CartOuterClass.Cart>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CartOuterClass.GetCartRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CartOuterClass.Cart.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("GetCart"))
              .build();
        }
      }
    }
    return getGetCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CartOuterClass.EmptyCartRequest,
      CartOuterClass.Empty> getEmptyCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmptyCart",
      requestType = CartOuterClass.EmptyCartRequest.class,
      responseType = CartOuterClass.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CartOuterClass.EmptyCartRequest,
      CartOuterClass.Empty> getEmptyCartMethod() {
    io.grpc.MethodDescriptor<CartOuterClass.EmptyCartRequest, CartOuterClass.Empty> getEmptyCartMethod;
    if ((getEmptyCartMethod = CartServiceGrpc.getEmptyCartMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getEmptyCartMethod = CartServiceGrpc.getEmptyCartMethod) == null) {
          CartServiceGrpc.getEmptyCartMethod = getEmptyCartMethod =
              io.grpc.MethodDescriptor.<CartOuterClass.EmptyCartRequest, CartOuterClass.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EmptyCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CartOuterClass.EmptyCartRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CartOuterClass.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("EmptyCart"))
              .build();
        }
      }
    }
    return getEmptyCartMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CartServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartServiceStub>() {
        @java.lang.Override
        public CartServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartServiceStub(channel, callOptions);
        }
      };
    return CartServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CartServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartServiceBlockingStub>() {
        @java.lang.Override
        public CartServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartServiceBlockingStub(channel, callOptions);
        }
      };
    return CartServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CartServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartServiceFutureStub>() {
        @java.lang.Override
        public CartServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartServiceFutureStub(channel, callOptions);
        }
      };
    return CartServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addItem(CartOuterClass.AddItemRequest request,
                         io.grpc.stub.StreamObserver<CartOuterClass.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddItemMethod(), responseObserver);
    }

    /**
     */
    default void getCart(CartOuterClass.GetCartRequest request,
                         io.grpc.stub.StreamObserver<CartOuterClass.Cart> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCartMethod(), responseObserver);
    }

    /**
     */
    default void emptyCart(CartOuterClass.EmptyCartRequest request,
                           io.grpc.stub.StreamObserver<CartOuterClass.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEmptyCartMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CartService.
   */
  public static abstract class CartServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CartServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CartService.
   */
  public static final class CartServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CartServiceStub> {
    private CartServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartServiceStub(channel, callOptions);
    }

    /**
     */
    public void addItem(CartOuterClass.AddItemRequest request,
                        io.grpc.stub.StreamObserver<CartOuterClass.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddItemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCart(CartOuterClass.GetCartRequest request,
                        io.grpc.stub.StreamObserver<CartOuterClass.Cart> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void emptyCart(CartOuterClass.EmptyCartRequest request,
                          io.grpc.stub.StreamObserver<CartOuterClass.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEmptyCartMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CartService.
   */
  public static final class CartServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CartServiceBlockingStub> {
    private CartServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public CartOuterClass.Empty addItem(CartOuterClass.AddItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddItemMethod(), getCallOptions(), request);
    }

    /**
     */
    public CartOuterClass.Cart getCart(CartOuterClass.GetCartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCartMethod(), getCallOptions(), request);
    }

    /**
     */
    public CartOuterClass.Empty emptyCart(CartOuterClass.EmptyCartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEmptyCartMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CartService.
   */
  public static final class CartServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CartServiceFutureStub> {
    private CartServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CartOuterClass.Empty> addItem(
        CartOuterClass.AddItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddItemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CartOuterClass.Cart> getCart(
        CartOuterClass.GetCartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCartMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CartOuterClass.Empty> emptyCart(
        CartOuterClass.EmptyCartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEmptyCartMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_ITEM = 0;
  private static final int METHODID_GET_CART = 1;
  private static final int METHODID_EMPTY_CART = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_ITEM:
          serviceImpl.addItem((CartOuterClass.AddItemRequest) request,
              (io.grpc.stub.StreamObserver<CartOuterClass.Empty>) responseObserver);
          break;
        case METHODID_GET_CART:
          serviceImpl.getCart((CartOuterClass.GetCartRequest) request,
              (io.grpc.stub.StreamObserver<CartOuterClass.Cart>) responseObserver);
          break;
        case METHODID_EMPTY_CART:
          serviceImpl.emptyCart((CartOuterClass.EmptyCartRequest) request,
              (io.grpc.stub.StreamObserver<CartOuterClass.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddItemMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CartOuterClass.AddItemRequest,
              CartOuterClass.Empty>(
                service, METHODID_ADD_ITEM)))
        .addMethod(
          getGetCartMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CartOuterClass.GetCartRequest,
              CartOuterClass.Cart>(
                service, METHODID_GET_CART)))
        .addMethod(
          getEmptyCartMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CartOuterClass.EmptyCartRequest,
              CartOuterClass.Empty>(
                service, METHODID_EMPTY_CART)))
        .build();
  }

  private static abstract class CartServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CartServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CartOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CartService");
    }
  }

  private static final class CartServiceFileDescriptorSupplier
      extends CartServiceBaseDescriptorSupplier {
    CartServiceFileDescriptorSupplier() {}
  }

  private static final class CartServiceMethodDescriptorSupplier
      extends CartServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CartServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CartServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CartServiceFileDescriptorSupplier())
              .addMethod(getAddItemMethod())
              .addMethod(getGetCartMethod())
              .addMethod(getEmptyCartMethod())
              .build();
        }
      }
    }
    return result;
  }
}
