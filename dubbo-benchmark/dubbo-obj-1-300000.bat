java -Xms2G -Xmx2G -cp .;./dubbo-client/target/classes;./dubbo-client/target/lib/* -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc1.log -Dwrite.statistics=true DubboTest 1 300000 true false > dubbo_benchmark_obj_1_300000.log
pause