java -Xms2G -Xmx2G -cp ./target/classes;./target/lib/* -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc5.log -Dwrite.statistics=true com.unionpay.rpc.benchmark.grpc.common.GrpcTest 100 300000 true false> grpc_benchmark_obj_100_300000.log
pause