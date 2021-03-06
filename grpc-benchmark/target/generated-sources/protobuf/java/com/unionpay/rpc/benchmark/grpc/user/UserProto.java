// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.unionpay.rpc.benchmark.grpc.user;

public final class UserProto {
  private UserProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_UserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_UserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_UserReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_UserReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_UserReplyStr_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_UserReplyStr_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_User_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nuser.proto\022\004user\"\035\n\013UserRequest\022\016\n\006use" +
      "rId\030\001 \001(\003\"%\n\tUserReply\022\030\n\004user\030\001 \001(\0132\n.u" +
      "ser.User\" \n\014UserReplyStr\022\020\n\010userName\030\001 \001" +
      "(\t\"\261\001\n\004User\022\016\n\006userId\030\001 \001(\003\022\020\n\010userName\030" +
      "\002 \001(\t\022\r\n\005phone\030\003 \001(\t\022\r\n\005email\030\004 \001(\t\022\017\n\007a" +
      "ddress\030\005 \001(\t\022\013\n\003age\030\006 \001(\005\022\016\n\006gender\030\007 \001(" +
      "\005\022\022\n\nuserStatus\030\010 \001(\005\022\021\n\tcreatedAt\030\t \001(\003" +
      "\022\024\n\014lastModified\030\n \001(\0032v\n\013UserService\022/\n" +
      "\007getUser\022\021.user.UserRequest\032\017.user.UserR" +
      "eply\"\000\0226\n\013getUserName\022\021.user.UserRequest",
      "\032\022.user.UserReplyStr\"\000B3\n$com.unionpay.r" +
      "pc.benchmark.grpc.userB\tUserProtoP\001b\006pro" +
      "to3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_user_UserRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_user_UserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_UserRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_user_UserReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_user_UserReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_UserReply_descriptor,
        new java.lang.String[] { "User", });
    internal_static_user_UserReplyStr_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_user_UserReplyStr_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_UserReplyStr_descriptor,
        new java.lang.String[] { "UserName", });
    internal_static_user_User_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_user_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_User_descriptor,
        new java.lang.String[] { "UserId", "UserName", "Phone", "Email", "Address", "Age", "Gender", "UserStatus", "CreatedAt", "LastModified", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
