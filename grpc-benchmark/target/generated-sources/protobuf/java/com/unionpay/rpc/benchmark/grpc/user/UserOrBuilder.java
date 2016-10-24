// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.unionpay.rpc.benchmark.grpc.user;

public interface UserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:user.User)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 userId = 1;</code>
   */
  long getUserId();

  /**
   * <code>optional string userName = 2;</code>
   */
  java.lang.String getUserName();
  /**
   * <code>optional string userName = 2;</code>
   */
  com.google.protobuf.ByteString
      getUserNameBytes();

  /**
   * <code>optional string phone = 3;</code>
   */
  java.lang.String getPhone();
  /**
   * <code>optional string phone = 3;</code>
   */
  com.google.protobuf.ByteString
      getPhoneBytes();

  /**
   * <code>optional string email = 4;</code>
   */
  java.lang.String getEmail();
  /**
   * <code>optional string email = 4;</code>
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>optional string address = 5;</code>
   */
  java.lang.String getAddress();
  /**
   * <code>optional string address = 5;</code>
   */
  com.google.protobuf.ByteString
      getAddressBytes();

  /**
   * <code>optional int32 age = 6;</code>
   */
  int getAge();

  /**
   * <code>optional int32 gender = 7;</code>
   */
  int getGender();

  /**
   * <code>optional int32 userStatus = 8;</code>
   */
  int getUserStatus();

  /**
   * <code>optional int64 createdAt = 9;</code>
   */
  long getCreatedAt();

  /**
   * <code>optional int64 lastModified = 10;</code>
   */
  long getLastModified();
}