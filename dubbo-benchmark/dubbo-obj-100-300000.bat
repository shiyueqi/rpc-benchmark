java -Xms2G -Xmx2G -cp .;./dubbo-client/target/classes;./dubbo-client/target/lib/* -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc1.log -Dwrite.statistics=true com.unionpay.rpc.benchmark.dubbo.common.DubboTest 100 300000 true false > dubbo_benchmark_obj_100_300000.log
pause