# rpc-benchmark

## 简介

- 分别应用了 grpc/Thrift/dubbo rpc framework 进行了应用和测试
- netty boss线程池大小为10，worker线程池大小为200
- 通过startProvider.bat脚本，启动server端
- 通过类似grpc-obj-1-300000.bat脚本，启动client端
- client端脚本第一个表示应用哪个rpc framework
- client端脚本第二个表示调用server端哪种类型接口。server端提供了两种接口，一种为返回object，需要序列化，另一种为基本类型
- client端脚本第三个表示client端并发量为多少，即启动多少个client实例
- client端脚本第四个表示client端单个实例调用量
- client端脚本中main方法的args为4个元素的数组，第一个为client端实例数量，第二个为client端调用量，第三个为是否调用obj接口，第四个为是否调用string接口


# Grpc
## Grpc Rpc Framework
1. google 开源的rpc framework，https://github.com/grpc/grpc-java
2. 使用了HTTP/2协议
3. 使用了Proto Bufffer高性能序列化协议，https://github.com/google/protobuf
4. 使用了protobuf插件，通过.proto文件生成java类
5. 拥有流式调用，阻塞调用，异步调用等特性
6. 支持了thrift序列化协议
7. 通过IDL语言，生成类；通过HTTP/2 协议实现跨平台，跨语言的支持
8. 暂时推出了1.0.1版本，但缺点仍然较多
8.1 不支持服务发现与注册
8.2 不支持集群
8.3 不支持配置文件形式对服务进行定义
8.4 不支持监控
8.5 不支持流量控制（扼流等）
8.6 压缩协议支持较少（暂支持gzip）
8.7 暂不支持负载均衡

## Grpc benchmark
1. mvn clean install -DskipTests
2. 运行startProvider.bat，启动server
3. 运行grpc-obj-1-300000.bat，启动client
4. 等待benchmark性能测试日志生成



# Thrift
## Thrift Rpc Framework
1. apache 顶级开源项目，https://github.com/apache/thrift
2. 使用了thrift序列化协议
3. 使用了IDL语言，通过类似grpc的plugin进行java类生成

## Thrift benchmark
1. 运行gen.bat脚本，生成java类，（研究不细：个人直接将类拷贝到指定位置）
2. mvn clean install -DskipTests
3. 运行startProvider.bat，启动server
4. 运行thrift-obj-1-300000.bat，启动client
5. 等待benchmark性能测试日志生成



# Dubbo
## Dubbo Rpc Framework
1. alibaba 开源 rpc framework，https://github.com/alibaba/dubbo
2. 存在较久，大家研究较多，暂不赘述

## Dubbo benchmark
1. mvn clean install -DskipTests
2. 运行startProvider.bat，启动server
3. 运行dubbo-obj-1-300000.bat，启动client
4. 等待benchmark性能测试日志生成
