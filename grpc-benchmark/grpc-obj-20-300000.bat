java -Xms2G -Xmx2G -cp ./target/classes;./target/lib/* -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc5.log -Dwrite.statistics=true GrpcTest 20 300000 true false> grpc_benchmark_obj_20_300000.log
pause