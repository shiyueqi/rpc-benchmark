java -Xms2G -Xmx2G  -cp ./target/classes;./target/lib/*  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc1.log -Dwrite.statistics=true ThriftTest 20 300000 true false > thrift_benchmark_obj_20_300000.log
pause