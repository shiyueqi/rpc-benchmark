java -Xms2G -Xmx2G  -cp ./target/classes;./target/lib/*  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc1.log -Dwrite.statistics=true ThriftTest 50 300000 false true > thrift_benchmark_string_50_300000.log
pause