java -Xms2G -Xmx2G -cp ./target/classes;./target/lib/* -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc5.log -Dwrite.statistics=true GrpcTest 50 300000 false true > grpc_benchmark_string_50_300000.log
pause